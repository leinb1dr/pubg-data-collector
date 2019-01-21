package io.leinbach.pubg.ingestor.controller;

import io.leinbach.pubg.clients.PlayersClient;
import io.leinbach.pubg.data.dao.PlayerDao;
import io.leinbach.pubg.domain.PlayerDto;
import io.leinbach.pubg.exceptions.HttpExceptions;
import io.leinbach.pubg.exceptions.NotFoundException;
import io.leinbach.pubg.ingestor.controller.util.RefreshPlayer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leinb
 * @since 1/3/2019
 */
@RestController
public class PlayerController {

    private final PlayersClient playersClient;
    private final PlayerDao playerDao;
    private final RefreshPlayer refreshPlayer;

    public PlayerController(PlayersClient playersClient, PlayerDao playerDao, RefreshPlayer refreshPlayer) {
        this.playersClient = playersClient;
        this.playerDao = playerDao;
        this.refreshPlayer = refreshPlayer;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/player")
    public Mono<PlayerDto> findPlayer(@RequestParam String player) {

        return playerDao.getPlayer(player)
                .switchIfEmpty(playersClient.findPlayer(player)
                        .flatMap(playerDao::savePlayer))
                .flatMap(playerDto -> {
                    if (playerDto.needsRefresh()) return refreshPlayer.refreshPlayer(playerDto);
                    return Mono.just(playerDto);
                })
                .onErrorResume(NotFoundException.class, e -> Mono.just(new PlayerDto()));
//                .flatMap(playerDto -> ServerResponse.ok()
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .syncBody(playerDto))
//                .onErrorResume(NotFoundException.class, throwable -> ServerResponse.ok()
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .body(Mono.just(new HashMap<String, Object>()), Map.class))
//                .onErrorResume(HttpExceptions.class, throwable -> ServerResponse.status(throwable.getStatusCode())
//                        .body(Mono.just(throwable), HttpExceptions.class));


//                .flatMap(playerDto -> playerMatchDao.findMatchesForPlayer(playerDto.getId())
//                        .collectList()
//                        .map(playerDto::matches));

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/player/{playerId}")
    public Mono<PlayerDto> getPlayer(@PathVariable String playerId) {

        return playerDao.getPlayerById(playerId)
                .flatMap(playerDto -> {
                    if (playerDto.needsRefresh()) return refreshPlayer.refreshPlayer(playerDto);
                    return Mono.just(playerDto);
                });
//                .flatMap(playerDto -> playerMatchDao.findMatchesForPlayer(playerDto.getId())
//                        .collectList()
//                        .map(playerDto::matches));

    }


}
