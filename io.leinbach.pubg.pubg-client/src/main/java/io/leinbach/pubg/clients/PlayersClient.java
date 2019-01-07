package io.leinbach.pubg.clients;

import io.leinbach.pubg.clients.domain.Platform;
import io.leinbach.pubg.clients.domain.PlayerListResult;
import io.leinbach.pubg.clients.domain.PubgPlayer;
import io.leinbach.pubg.domain.PlayerDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;

import static io.leinbach.pubg.constants.Paths.PLAYERS;
import static io.leinbach.pubg.constants.Paths.PLAYER_NAMES_FILTER;

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

    public Flux<PlayerDto> searchPlayers(String playerName) {
        return webClient.get()
                .uri(PLAYERS + "?" + PLAYER_NAMES_FILTER, Platform.STEAM.getName(), playerName)
                .header("accept", "application/json")
                .retrieve()
                .bodyToMono(PlayerListResult.class)
                .onErrorReturn(throwable -> {
                    if (throwable instanceof WebClientResponseException) {
                        return HttpStatus.NOT_FOUND.equals(((WebClientResponseException) throwable).getStatusCode());
                    }
                    return false;
                }, new PlayerListResult())
                .flatMapMany(playerListResult -> Flux.fromIterable(playerListResult.getData()))
                .map(PubgPlayer::to);
    }

}
