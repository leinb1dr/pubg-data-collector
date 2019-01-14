package io.leinbach.pubg.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.leinbach.pubg.clients.telemetry.TelemetryBase;
import io.leinbach.pubg.domain.EventDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Objects;

/**
 * @author leinb
 * @since 12/24/2018
 */
@Component
public class TelemetryClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(TelemetryClient.class);

    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    public TelemetryClient(WebClient webClient, ObjectMapper objectMapper) {
        this.webClient = webClient;
        this.objectMapper = objectMapper;
    }


    public Flux<EventDto> loadTelemetry(String url) {
        return webClient.get()
                .uri(url)
                .header("accept", "application/json")
                .retrieve()
                .bodyToFlux(TelemetryBase.class)
                .map(TelemetryBase::to);

    }

}
