package io.leinbach.pubg.clients;

import io.leinbach.pubg.clients.domain.*;
import io.leinbach.pubg.domain.PlayerDto;
import io.leinbach.pubg.exceptions.HttpExceptions;
import io.leinbach.pubg.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static io.leinbach.pubg.constants.Paths.PLAYERS;
import static io.leinbach.pubg.constants.Paths.PLAYER_NAMES_FILTER;
import static io.leinbach.pubg.constants.Paths.SEASON_STATS;

/**
 * @author leinb
 * @since 12/24/2018
 */
@Component
public class PlayersClient {

    private final WebClient webClient;

    public PlayersClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<PlayerDto> findPlayer(String playerName) {
        return webClient.get()
                .uri(PLAYERS + "?" + PLAYER_NAMES_FILTER, Platform.STEAM.getName(), playerName)
                .header("accept", "application/json")
                .retrieve()
                .bodyToMono(PlayerListResult.class)
                .flatMapMany(playerListResult -> Flux.fromIterable(playerListResult.getData()))
                .single()
                .map(PlayerEntity::to)
                .onErrorMap(throwable-> {
                    if (throwable instanceof WebClientResponseException) {
                        if(HttpStatus.NOT_FOUND.equals(((WebClientResponseException) throwable).getStatusCode())){
                            return new NotFoundException(throwable);
                        }
                    }
                    return new HttpExceptions(throwable, 500);
                });
    }

    public Mono<PlayerDto> getSeasonStats(String id, String season) {
        return webClient.get()
                .uri(SEASON_STATS, Platform.STEAM.getName(), id, season)
                .header("accept", "application/json")
                .retrieve()
                .bodyToMono(PlayerSeason.class)
                .onErrorReturn(throwable -> {
                    if (throwable instanceof WebClientResponseException) {
                        return HttpStatus.NOT_FOUND.equals(((WebClientResponseException) throwable).getStatusCode());
                    }
                    return false;
                }, new PlayerSeason())
                .map(PlayerSeason::getData)
                .map(PlayerSeasonEntity::to);
    }
}
