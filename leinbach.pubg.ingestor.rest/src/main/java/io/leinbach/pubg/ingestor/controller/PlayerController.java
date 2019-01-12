package io.leinbach.pubg.ingestor.controller;

import io.leinbach.pubg.clients.PlayersClient;
import io.leinbach.pubg.data.dao.MatchProcessingDao;
import io.leinbach.pubg.data.dao.PlayerDao;
import io.leinbach.pubg.domain.PlayerDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author leinb
 * @since 1/3/2019
 */
@RestController
public class PlayerController {

    private final PlayersClient playersClient;
    private final PlayerDao playerDao;
    private final MatchProcessingDao matchProcessingDao;
    private final AmqpTemplate amqpTemplate;

    public PlayerController(PlayersClient playersClient, PlayerDao playerDao, MatchProcessingDao matchProcessingDao, AmqpTemplate amqpTemplate) {
        this.playersClient = playersClient;
        this.playerDao = playerDao;
        this.matchProcessingDao = matchProcessingDao;
        this.amqpTemplate = amqpTemplate;
    }

    @GetMapping("/player")
    public Mono<PlayerDto> handle(@RequestParam String player) {

        return playerDao.getPlayer(player)
                .switchIfEmpty(
                        playersClient.findPlayer(player)
                                .flatMap(playerDao::createPlayer))
                .flatMap(playerDto -> {
                    if (playerDto.needsRefresh()) return refreshPlayer(playerDto);
                    return Mono.just(playerDto);
                });

    }

    private Mono<PlayerDto> refreshPlayer(PlayerDto playerDto) {
        return playersClient.findPlayer(playerDto.getName())
                .flatMapMany(pubgPlayer -> Flux.fromIterable(pubgPlayer.getMatches()))
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
