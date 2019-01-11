package io.leinbach.pubg.ingestor.consumer.match;

import io.leinbach.pubg.clients.MatchesClient;
import io.leinbach.pubg.clients.TelemetryClient;
import io.leinbach.pubg.domain.MatchDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author leinb
 * @since 1/6/2019
 */
@Component
public class MatchConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MatchConsumer.class);

    private final MatchesClient matchClient;
    private final TelemetryClient telemetryClient;
    private final AmqpTemplate amqpTemplate;

    public MatchConsumer(MatchesClient matchClient, TelemetryClient telemetryClient, AmqpTemplate amqpTemplate) {
        this.matchClient = matchClient;
        this.telemetryClient = telemetryClient;
        this.amqpTemplate = amqpTemplate;
    }

    @RabbitListener(queues = "MATCH",concurrency = "1")
    public void processMatch(MatchDto matchDto) {
        LOGGER.info(matchDto.toString());
        matchClient.getMatch(matchDto.getId())
                .flatMapMany(matchData -> telemetryClient.getMatch(matchData.getTelemetryUrl())
                        .map(eventDto -> eventDto.matchId(matchData.getId())))
                .flatMap(eventDto -> Mono.fromCallable(()->{
                    amqpTemplate.convertAndSend(
                            "event.processing",
                            eventDto.getEventName(),
                            eventDto);
                    return true;
                }))
                .blockLast();
        LOGGER.info("COMPLETE");

    }
}
