package io.leinbach.pubg.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author leinb
 * @since 12/25/2018
 */
@Configuration
@EnableConfigurationProperties(PubgClientProperties.class)
@ComponentScan("io.leinbach.pubg")
public class PubgClientConfiguration {
    private final PubgClientProperties pubgClientProperties;

    public PubgClientConfiguration(PubgClientProperties pubgClientProperties) {
        this.pubgClientProperties = pubgClientProperties;
    }

    @Bean
    public WebClient pubgWebClient() {
        return WebClient.builder()
                .baseUrl("https://api.pubg.com")
                .defaultHeader("Authorization", "Bearer " + pubgClientProperties.jwt())
                .build();
    }
}
