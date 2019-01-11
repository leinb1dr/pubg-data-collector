package io.leinbach.pubg.ingestor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author leinb
 * @since 12/26/2018
 */
@SpringBootApplication
@ComponentScan(basePackages = "io.leinbach.pubg")
public class Application {

    @Bean
    public MessageConverter jsonMessageConverter(ObjectMapper objectMapper){
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
