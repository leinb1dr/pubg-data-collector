package io.leinbach.pubg.clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.leinbach.pubg.clients.domain.*;
import io.leinbach.pubg.domain.MatchDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

import static io.leinbach.pubg.constants.Paths.MATCHE;

/**
 * @author leinb
 * @since 12/24/2018
 */
@Component
public class MatchesClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(MatchesClient.class);

    private final WebClient webClient;

    public MatchesClient(WebClient webClient) {
        this.webClient = webClient;
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

//                .flatMapMany(matchData -> Flux.fromIterable(matchData.getData()))
                .flatMap(matchData -> {
                    LOGGER.info(matchData.toString());
                    MatchEntity matchEntity = matchData.getData();
                    List<? extends PubgEntity> included = matchData.getIncluded();
                    String assetId = matchEntity.getRelationships()
                            .getAssets()
                            .getData()
                            .get(0)
                            .getId();

                    int i = included.indexOf(new AssetEntity().type(EntityType.ASSET)
                            .id(assetId));

                    AssetEntity assetEntity = (AssetEntity) included.get(i);
                    LOGGER.info(assetEntity.toString());

                    return WebClient.create()
                            .get()
                            .uri(assetEntity.getAttributes().getUrl())
                            .retrieve()
                            .bodyToFlux(Map.class)
                            .doOnEach(map -> {
                                try {
                                    LOGGER.info(new ObjectMapper().writerWithDefaultPrettyPrinter()
                                            .writeValueAsString(map.get()));
                                } catch (JsonProcessingException e) {
                                    e.printStackTrace();
                                }
                            })
                            .collectList()
                            .map(ignore->matchEntity);

                })
                .map(MatchEntity::to);
    }

}
