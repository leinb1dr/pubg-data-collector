package io.leinbach.pubg.ingestor.consumer;

import io.leinbach.pubg.clients.MatchesClient;
import io.leinbach.pubg.clients.TelemetryClient;
import io.leinbach.pubg.data.dao.AttackEventDao;
import io.leinbach.pubg.domain.EventDto;
import io.leinbach.pubg.domain.MatchDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author leinb
 * @since 1/6/2019
 */
@Component
public class MatchConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MatchConsumer.class);

    private final MatchesClient matchClient;
    private final TelemetryClient telemetryClient;
    private final AttackEventDao attackEventDao;

    public MatchConsumer(MatchesClient matchClient, TelemetryClient telemetryClient, AttackEventDao attackEventDao) {
        this.matchClient = matchClient;
        this.telemetryClient = telemetryClient;
        this.attackEventDao = attackEventDao;
    }

    @RabbitListener(queues = "MATCH")
    public void processMatch(MatchDto matchDto) {
        LOGGER.info(matchDto.toString());
        matchClient.getMatch(matchDto.getId())
                .flatMapMany(matchData -> telemetryClient.getMatch(matchData.getTelemetryUrl())
                        .map(eventDto -> eventDto.matchId(matchData.getId())))
                .take(10)
                .flatMap(attackEventDao::createEvent)
                .map(EventDto::toString)
                .subscribe(LOGGER::info, throwable -> LOGGER.error("failed", throwable));

    }
}
