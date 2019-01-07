package io.leinbach.pubg.ingestor.consumer;

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

    Logger logger = LoggerFactory.getLogger(MatchConsumer.class);

    @RabbitListener(queues = "MATCH")
    public void processMatch(MatchDto matchDto){
        logger.info(matchDto.toString());

    }
}
