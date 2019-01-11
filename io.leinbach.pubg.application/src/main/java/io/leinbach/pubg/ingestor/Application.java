package io.leinbach.pubg.ingestor;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
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
    public ParameterNamesModule parameterNamesModule(){
        return new ParameterNamesModule(JsonCreator.Mode.PROPERTIES);
    }

    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
