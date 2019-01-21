package io.leinbach.pubg.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.leinbach.pubg.clients.domain.*;
import io.leinbach.pubg.domain.MatchDto;
import io.leinbach.pubg.domain.ParticipantsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.leinbach.pubg.constants.Paths.MATCHE;

/**
 * @author leinb
 * @since 12/24/2018
 */
@Component
public class MatchesClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(MatchesClient.class);

    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    public MatchesClient(WebClient webClient, ObjectMapper objectMapper) {
        this.webClient = webClient;
        this.objectMapper = objectMapper;
    }

    public Mono<MatchDto> getMatch(String matchId) {
        return webClient.get()
                .uri(MATCHE, Platform.STEAM.getName(), matchId)
                .header("accept", "application/json")
                .retrieve()
                .bodyToMono(MatchData.class)
                .onErrorReturn(throwable -> {
                    if (throwable instanceof WebClientResponseException) {
                        return HttpStatus.NOT_FOUND.equals(((WebClientResponseException) throwable).getStatusCode());
                    }
                    return false;
                }, new MatchData())

                .map(matchData -> {
                    MatchEntity matchEntity = matchData.getData();

                    List<? extends PubgEntity> included = matchData.getIncluded();

                    HashMap<String, ParticipantsDto> participantsMap = included.stream()
                            .flatMap(pubgEntity -> {

                                if (pubgEntity instanceof ParticipantEntity) {
                                    ParticipantEntity participantEntity = (ParticipantEntity) pubgEntity;
                                    ParticipantStats stats = participantEntity.getAttributes()
                                            .getStats();
                                    Map<String, Object> mapOfStats = objectMapper.convertValue(stats, Map.class);

                                    return Stream.of(new SimpleEntry<>(participantEntity.getId(), new ParticipantsDto()
                                            .matchId(matchEntity.getId())
                                            .accountId(stats.getPlayerId())
                                            .playerName(stats.getName())
                                            .stats(mapOfStats)));

                                } else if (pubgEntity instanceof RosterEntity) {

                                    RosterEntity rosterEntity = (RosterEntity) pubgEntity;
                                    RosterStats stats = rosterEntity.getAttributes()
                                            .getStats();
                                    return rosterEntity.getRelationships()
                                            .getParticipants()
                                            .getData()
                                            .stream()
                                            .map(participantEntity ->
                                                    new SimpleEntry<>(participantEntity.getId(),
                                                            new ParticipantsDto().rank(stats.getRank())
                                                                    .teamId(stats.getTeamId())));

                                }
                                return Stream.empty();
                            })
                            .collect(HashMap::new,
                                    (map, entry) -> map.compute(entry.getKey(), (key, dto) -> {
                                        if (dto == null) {
                                            return entry.getValue();
                                        }
                                        return merge(dto, entry.getValue());
                                    }),
                                    (map1, map2) -> {
                                        Set<String> keys = map2.keySet();

                                        keys.forEach(key -> map1.put(key, merge(map1.get(key), map2.get(key))));
                                    });


                    String assetId = matchEntity.getRelationships()
                            .getAssets()
                            .getData()
                            .get(0)
                            .getId();

                    int i = included.indexOf(new AssetEntity().type(EntityType.ASSET)
                            .id(assetId));

                    AssetEntity assetEntity = (AssetEntity) included.get(i);
                    return matchEntity.to()
                            .participants(new ArrayList<>(participantsMap.values()))
                            .telemetryUrl(assetEntity.getAttributes()
                                    .getUrl());
                });
    }

    private ParticipantsDto merge(ParticipantsDto dto1, ParticipantsDto dto2) {
        if (dto1 == null) return dto2;
        if (dto2 == null) return dto1;
        return new ParticipantsDto()
                .matchId(dto1.getMatchId() != null ? dto1.getMatchId() : dto2.getMatchId())
                .playerName(dto1.getPlayerName() != null ? dto1.getPlayerName() : dto2.getPlayerName())
                .teamId(dto1.getTeamId() > 0 ? dto1.getTeamId() : dto2.getTeamId())
                .accountId(dto1.getAccountId() != null ? dto1.getAccountId() : dto2.getAccountId())
                .rank(dto1.getRank() > 0 ? dto1.getRank() : dto2.getRank())
                .stats(dto1.getStats() != null ? dto1.getStats() : dto2.getStats());
    }

}
