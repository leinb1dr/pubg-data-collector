package io.leinbach.pubg.data.dao;

import io.leinbach.pubg.data.entity.PlayerMatch;
import io.leinbach.pubg.data.entity.PlayerMatchId;
import io.leinbach.pubg.data.repository.PlayerMatchRepository;
import io.leinbach.pubg.domain.MatchDto;
import io.leinbach.pubg.domain.ParticipantsDto;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * @author leinb
 * @since 1/13/2019
 */
@Component
public class PlayerMatchDao {

    Function<PlayerMatch, MatchDto> matchTransformer = playerMatch -> new MatchDto()
                        .stats(playerMatch.getStats())
                        .id(playerMatch.getId()
                                .getMatchId())
                        .rank(playerMatch.getRank())
                        .teamId(playerMatch.getTeamId());

    private final PlayerMatchRepository repository;

    public PlayerMatchDao(PlayerMatchRepository repository) {
        this.repository = repository;
    }

    public Flux<MatchDto> findMatchesForPlayer(String accountId) {
        return repository.findAllByIdAccountId(accountId)
                .map(matchTransformer);
    }

    public Flux<ParticipantsDto> findTeamForPlayer(String matchId, int teamId){
        return repository.findAllByIdMatchIdAndTeamId(matchId, teamId)
                .map(PlayerMatch::to);
    }

    public Mono<ParticipantsDto> savePlayerMatch(ParticipantsDto participantsDto) {
        return Mono.just(participantsDto)
                .map(PlayerMatch::from)
                .flatMap(repository::save)
                .map(PlayerMatch::to);
    }

    public Mono<MatchDto> getMatch(String accountId, String matchId) {
        return repository.findById(new PlayerMatchId(accountId,matchId))
                .map(matchTransformer);
    }
}
