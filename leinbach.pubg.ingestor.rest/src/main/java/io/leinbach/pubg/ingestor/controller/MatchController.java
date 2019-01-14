package io.leinbach.pubg.ingestor.controller;

import io.leinbach.pubg.data.dao.PlayerDao;
import io.leinbach.pubg.data.dao.PlayerMatchDao;
import io.leinbach.pubg.domain.MatchDto;
import io.leinbach.pubg.domain.PlayerDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author leinb
 * @since 1/14/2019
 */
@RestController
public class MatchController {

    private final PlayerDao playerDao;
    private final PlayerMatchDao playerMatchDao;

    public MatchController(PlayerDao playerDao, PlayerMatchDao playerMatchDao) {
        this.playerDao = playerDao;
        this.playerMatchDao = playerMatchDao;
    }

    @GetMapping("/player/{accountId}/match/{matchId}")
    public Mono<MatchDto> getMatch(@PathVariable String accountId, @PathVariable String matchId) {
        Mono<PlayerDto> playerById = playerDao.getPlayerById(accountId);

        return playerMatchDao.getMatch(accountId, matchId)
                .flatMap(matchDto -> playerMatchDao.findTeamForPlayer(matchId, matchDto.getTeamId())
                        .collectList()
                        .map(matchDto::participants));
    }

}
