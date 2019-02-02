package io.leinbach.pubg.ingestor.controller.util;

import io.leinbach.pubg.clients.PlayersClient;
import io.leinbach.pubg.data.dao.MatchProcessingDao;
import io.leinbach.pubg.data.dao.PlayerDao;
import io.leinbach.pubg.domain.PlayerDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * @author leinb
 * @since 1/17/2019
 */
@Component
public class RefreshPlayer {

    private final PlayersClient playersClient;
    private final PlayerDao playerDao;
    private final MatchProcessingDao matchProcessingDao;
    private final AmqpTemplate amqpTemplate;

    public RefreshPlayer(PlayersClient playersClient, PlayerDao playerDao, MatchProcessingDao matchProcessingDao, AmqpTemplate amqpTemplate) {
        this.playersClient = playersClient;
        this.playerDao = playerDao;
        this.matchProcessingDao = matchProcessingDao;
        this.amqpTemplate = amqpTemplate;
    }


    public Mono<PlayerDto> refreshPlayer(PlayerDto playerDto) {
        return playersClient.getSeasonStats(playerDto.getId(), "division.bro.official.pc-2018-02")
                .flatMap(playerWithSeason -> Mono.just(playerWithSeason.name(playerDto.getName()))
                        .map(player -> player.lastUpdate(LocalDateTime.now()))
                        .flatMap(playerDao::savePlayer)
                        .map(refreshedPlayer -> refreshedPlayer.matches(playerWithSeason.getMatches())))
                .flatMapMany(pubgPlayer -> Flux.fromIterable(pubgPlayer.getMatches()))
//                .take(1)
                .flatMap(matchDto -> matchProcessingDao.needsProcessing(matchDto)
                        .flatMap(needsProcessing -> {
                            if (needsProcessing) {
                                return matchProcessingDao.markForProcessing(matchDto)
                                        .flatMap(match -> Mono.fromCallable(() -> {
                                            amqpTemplate.convertAndSend(
                                                    "match",
                                                    "MATCH",
                                                    match);
                                            return true;
                                        }));
                            } else {
                                return Mono.just(matchDto);
                            }
                        }))
                .collectList()
                .map(ignore -> playerDto);
    }
}
