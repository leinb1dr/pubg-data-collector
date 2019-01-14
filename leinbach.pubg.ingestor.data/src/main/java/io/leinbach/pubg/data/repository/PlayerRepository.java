package io.leinbach.pubg.data.repository;

import io.leinbach.pubg.data.entity.Player;
import io.leinbach.pubg.data.entity.PlayerMatch;
import io.leinbach.pubg.data.entity.PlayerMatchId;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author leinb
 * @since 1/11/2019
 */
@Repository
public interface PlayerRepository extends ReactiveCassandraRepository<Player, String> {

    Mono<Player> findByAccountId(String accountId);
}
