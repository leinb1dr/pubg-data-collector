package io.leinbach.pubg.ingestor.consumer;

import io.leinbach.pubg.clients.MatchesClient;
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

    public MatchConsumer(MatchesClient matchClient) {
        this.matchClient = matchClient;
    }

    @RabbitListener(queues = "MATCH")
    public void processMatch(MatchDto matchDto) {
        LOGGER.info(matchDto.toString());
        matchClient.getMatch(matchDto.getId())
                .map(MatchDto::toString)
                .subscribe(LOGGER::info, throwable -> LOGGER.error("failed", throwable));

    }
}
