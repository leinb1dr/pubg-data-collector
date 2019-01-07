package io.leinbach.pubg.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author leinb
 * @since 12/25/2018
 */
@Component
@ConfigurationProperties("pubg")
public class PubgClientProperties {
    private String jwt;

    public PubgClientProperties setJwt(String jwt) {
        this.jwt = jwt;
        return this;
    }

    public String jwt(){
        return jwt;
    }
}
