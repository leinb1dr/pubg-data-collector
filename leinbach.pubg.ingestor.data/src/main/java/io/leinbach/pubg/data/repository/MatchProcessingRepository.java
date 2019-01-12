package io.leinbach.pubg.data.repository;

import io.leinbach.pubg.data.entity.MatchProcessing;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

/**
 * @author leinb
 * @since 1/11/2019
 */
@Repository
public interface MatchProcessingRepository extends ReactiveCassandraRepository<MatchProcessing, String> {
}
