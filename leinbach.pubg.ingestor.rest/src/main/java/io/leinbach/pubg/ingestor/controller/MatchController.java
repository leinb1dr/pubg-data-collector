package io.leinbach.pubg.ingestor.controller;

import io.leinbach.pubg.data.dao.PlayerDao;
import io.leinbach.pubg.data.dao.PlayerMatchDao;
import io.leinbach.pubg.domain.MatchDto;
import io.leinbach.pubg.domain.PlayerDto;
import io.leinbach.pubg.ingestor.controller.util.RefreshPlayer;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author leinb
 * @since 1/14/2019
 */
@RestController
public class MatchController {

    private final PlayerDao playerDao;
    private final PlayerMatchDao playerMatchDao;
    private final RefreshPlayer refreshPlayer;

    public MatchController(PlayerDao playerDao, PlayerMatchDao playerMatchDao, RefreshPlayer refreshPlayer) {
        this.playerDao = playerDao;
        this.playerMatchDao = playerMatchDao;
        this.refreshPlayer = refreshPlayer;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/player/{accountId}/matches")
    public Flux<MatchDto> getMatches(@PathVariable String accountId, @RequestParam(required = false) String gameMode) {
        Mono<PlayerDto> playerById = playerDao.getPlayerById(accountId);
        playerDao.getPlayerById(accountId)
                .flatMap(playerDto -> {
                    if (playerDto.needsRefresh()) return refreshPlayer.refreshPlayer(playerDto);
                    return Mono.just(playerDto);
                }).subscribe();
        return playerMatchDao.findMatchesForPlayer(accountId, gameMode);
    }

    @GetMapping("/player/{accountId}/matches/{matchId}")
    public Mono<MatchDto> getMatch(@PathVariable String accountId, @RequestParam String gameMode, @PathVariable String matchId) {
        Mono<PlayerDto> playerById = playerDao.getPlayerById(accountId);

        return playerMatchDao.getMatch(accountId, gameMode, matchId)
                .flatMap(matchDto -> playerMatchDao.findTeamForPlayer(matchId, matchDto.getTeamId())
                        .collectList()
                        .map(matchDto::participants));
    }

}
