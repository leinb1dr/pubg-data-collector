package io.leinbach.pubg.data.repository;

import io.leinbach.pubg.data.entity.HeatMap;
import io.leinbach.pubg.data.entity.HeatMapStat;
import io.leinbach.pubg.data.entity.MatchProcessing;
import io.leinbach.pubg.domain.HeatMapStatsDto;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Map;

/**
 * @author leinb
 * @since 1/11/2019
 */
@Repository
public interface HeatMapRepository extends ReactiveCassandraRepository<HeatMap, String> {

}
