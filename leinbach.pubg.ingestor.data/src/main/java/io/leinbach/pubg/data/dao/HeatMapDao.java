package io.leinbach.pubg.data.dao;

import io.leinbach.pubg.data.entity.HeatMap;
import io.leinbach.pubg.domain.EventDto;
import org.springframework.data.cassandra.core.ReactiveCassandraOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author leinb
 * @since 1/10/2019
 */
@Component
public class HeatMapDao {
    private final ReactiveCassandraOperations operations;

    public HeatMapDao(ReactiveCassandraOperations operations) {
        this.operations = operations;
    }

    public Mono<EventDto> saveHeatmap(EventDto eventDto) {
        return operations.insert(HeatMap.from(eventDto))
                .map(event->eventDto);
    }
}
