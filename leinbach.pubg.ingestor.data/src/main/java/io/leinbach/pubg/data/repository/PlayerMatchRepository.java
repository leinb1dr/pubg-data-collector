package io.leinbach.pubg.data.repository;

import io.leinbach.pubg.data.entity.PlayerMatch;
import io.leinbach.pubg.data.entity.PlayerMatchId;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * @author leinb
 * @since 1/11/2019
 */
@Repository
public interface PlayerMatchRepository extends ReactiveCassandraRepository<PlayerMatch, PlayerMatchId> {
    Flux<PlayerMatch> findAllByIdAccountId(String accountId);

    @AllowFiltering
    Flux<PlayerMatch> findAllByIdMatchIdAndTeamId(String matchId, int teamId);
}
