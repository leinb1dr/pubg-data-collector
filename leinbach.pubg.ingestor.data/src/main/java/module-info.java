/**
 * @author leinb
 * @since 12/26/2018
 */
module leinbach.pubg.ingestor.data {
    requires spring.context;
    requires reactor.core;
    requires spring.data.cassandra;
    requires cassandra.driver.core;

    requires leinbach.pubg.ingestor.domain;
    
    exports io.leinbach.pubg.data.config to leinbach.pubg.application;
    exports io.leinbach.pubg.data.dao;

    exports io.leinbach.pubg.data.entity to leinbach.pubg.ingestor.domain, spring.data.commons;
    exports io.leinbach.pubg.data.repository to spring.aop;

    opens io.leinbach.pubg.data.config to spring.core, spring.context, spring.beans;
    opens io.leinbach.pubg.data.dao to spring.core, spring.context, spring.beans;
    opens io.leinbach.pubg.data.entity to spring.core, spring.context, spring.beans;
}