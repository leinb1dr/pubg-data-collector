package io.leinbach.pubg.ingestor.consumer.heatmap;

import io.leinbach.pubg.data.dao.HeatMapDao;
import io.leinbach.pubg.domain.EventDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author leinb
 * @since 1/6/2019
 */
@Component
public class HeatMapConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(HeatMapConsumer.class);

    private final HeatMapDao heatMapDao;

    public HeatMapConsumer(HeatMapDao heatMapDao) {
        this.heatMapDao = heatMapDao;
    }


    @RabbitListener(queues = "HEAT_MAP",concurrency = "1")
    public void processMatch(EventDto eventDto) {
        LOGGER.info(eventDto.toString());

        Mono.just(eventDto)
                .filter(event->event.getCharacter()!=null && event.getCharacter().getAccountId()!=null)
                .flatMap(heatMapDao::saveHeatmap)
                .block();
        LOGGER.info("COMPLETE");

    }
}
