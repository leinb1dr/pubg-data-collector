package io.leinbach.pubg.data.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.leinbach.pubg.data.entity.PlayerReadConverter;
import io.leinbach.pubg.data.entity.PlayerWriteConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
import org.springframework.data.cassandra.core.convert.CassandraCustomConversions;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;
import org.springframework.data.convert.CustomConversions;

import java.util.ArrayList;

/**
 * @author leinb
 * @since 12/27/2018
 */
@Configuration
@EnableReactiveCassandraRepositories(basePackages = { "io.leinbach.pubg.data.repository" })
public class DBConfig extends AbstractReactiveCassandraConfiguration {

    private final ObjectMapper objectMapper;

    public DBConfig(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public CustomConversions customConversions() {
        var converters = new ArrayList<Converter<?, ?>>();

        converters.add(new PlayerReadConverter(objectMapper));
        converters.add(new PlayerWriteConverter(objectMapper));

        return new CassandraCustomConversions(converters);
    }

    @Override
    protected boolean getMetricsEnabled() {
        return false;
    }

    @Override
    protected String getKeyspaceName() {
        return "pubg";
    }

    @Override
    protected String getContactPoints() {
        return "192.168.99.100";
    }
}
