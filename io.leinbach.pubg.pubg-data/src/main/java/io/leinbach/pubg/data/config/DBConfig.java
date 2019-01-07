package io.leinbach.pubg.data.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;

/**
 * @author leinb
 * @since 12/27/2018
 */
@Configuration
public class DBConfig extends AbstractReactiveCassandraConfiguration {

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
