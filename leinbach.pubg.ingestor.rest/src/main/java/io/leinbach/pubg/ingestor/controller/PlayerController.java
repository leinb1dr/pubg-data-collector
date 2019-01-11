package io.leinbach.pubg.ingestor.controller;

import io.leinbach.pubg.clients.PlayersClient;
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
    private final AmqpTemplate amqpTemplate;

    public PlayerController(PlayersClient playersClient, PlayerDao playerDao, AmqpTemplate amqpTemplate) {
        this.playersClient = playersClient;
        this.playerDao = playerDao;
        this.amqpTemplate = amqpTemplate;
    }

    @GetMapping("/player")
    public Mono<PlayerDto> handle(@RequestParam String player) {

//        var databaseLookup = playerDao.getPlayer(player)
//                .map(PlayerDto::from);

        var clientLookup = playersClient.searchPlayers(player)
                .flatMap(pubgPlayer -> Flux.fromIterable(pubgPlayer.getMatches())
//                        .take(1)
                        .flatMap(match -> Mono.fromCallable(() -> {
                            amqpTemplate.convertAndSend(
                                    "match",
                                    "MATCH",
                                    match);
                            return true;
                        }))
                        .collectList()
                        .map(ignore -> pubgPlayer))
                .single();
//                .map(PlayerTransformer::toDBPlayer)
//                .flatMap(playerDao::createPlayer)
//                .map(PlayerDto::from);

//       return databaseLookup.switchIfEmpty(clientLookup);
        return clientLookup;

    }
}
