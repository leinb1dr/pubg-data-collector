package io.leinbach.pubg.data.dao;

import com.datastax.driver.core.querybuilder.Clause;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import io.leinbach.pubg.data.entity.MatchProcessing;
import io.leinbach.pubg.data.entity.PlayerMatch;
import io.leinbach.pubg.data.entity.PlayerMatchId;
import io.leinbach.pubg.data.repository.PlayerMatchRepository;
import io.leinbach.pubg.domain.MatchDto;
import io.leinbach.pubg.domain.ParticipantsDto;
import org.springframework.data.cassandra.core.ReactiveCassandraOperations;
import org.springframework.data.cassandra.core.ReactiveCassandraTemplate;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.function.Function;

/**
 * @author leinb
 * @since 1/13/2019
 */
@Component
public class PlayerMatchDao {

    private final ReactiveCassandraTemplate template;
    private final ReactiveCassandraOperations operations;
    private final PlayerMatchRepository repository;
    Function<PlayerMatch, MatchDto> matchTransformer = playerMatch -> new MatchDto()
            .stats(playerMatch.getStats())
            .gameMode(playerMatch.getId()
                    .getGameMode())
            .matchDate(playerMatch.getMatchDateTime())
            .id(playerMatch.getId()
                    .getMatchId())
            .rank(playerMatch.getRank())
            .map(playerMatch.getMap())
            .teamId(playerMatch.getTeamId());

    public PlayerMatchDao(ReactiveCassandraTemplate template, ReactiveCassandraOperations operations, PlayerMatchRepository repository) {
        this.template = template;
        this.operations = operations;
        this.repository = repository;
    }

    public Flux<MatchDto> findMatchesForPlayer(String accountId, String gameMode) {

        Select.Where where = QueryBuilder.select()
                .from("playerMatch")
                .where(QueryBuilder.eq("accountId", accountId));
        if(gameMode != null) {
            where.and(QueryBuilder.eq("gameMode", gameMode));
        } else {
            where.allowFiltering();
        }

        return template.select(where, PlayerMatch.class)
                .map(matchTransformer)
                .sort(Comparator.comparing(MatchDto::getMatchDate));
//        return repository.findAllByIdAccountIdAndIdGameMode(accountId, gameMode)
//                .map(matchTransformer);
    }

    public Flux<ParticipantsDto> findTeamForPlayer(String matchId, int teamId) {
        return repository.findAllByIdMatchIdAndTeamId(matchId, teamId)
                .map(PlayerMatch::to);
    }

    public Mono<ParticipantsDto> savePlayerMatch(ParticipantsDto participantsDto) {
        return Mono.just(participantsDto)
                .map(PlayerMatch::from)
                .flatMap(repository::save)
                .map(PlayerMatch::to);
    }

    public Mono<MatchDto> getMatch(String accountId, String gameMode, String matchId) {
        return repository.findById(new PlayerMatchId(accountId, gameMode, matchId))
                .map(matchTransformer);
    }
}
