package io.leinbach.pubg.data.dao;

import io.leinbach.pubg.data.entity.AttackEvents;
import io.leinbach.pubg.domain.EventDto;
import org.springframework.data.cassandra.core.ReactiveCassandraOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author leinb
 * @since 1/10/2019
 */
@Component
public class AttackEventDao {
    private final ReactiveCassandraOperations operations;

    public AttackEventDao(ReactiveCassandraOperations operations) {
        this.operations = operations;
    }

    public Mono<EventDto> createEvent(EventDto eventDto) {
        return operations.insert(AttackEvents.from(eventDto))
                .map(event->eventDto);
    }
}
