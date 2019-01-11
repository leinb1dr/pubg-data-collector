/**
 * @author leinb
 * @since 12/26/2018
 */
module pubg.data {
    requires spring.context;
    requires reactor.core;
    requires spring.data.cassandra;
    requires cassandra.driver.core;

    requires ingester.domain;
    
    exports io.leinbach.pubg.data.config to pubg.application ;
    exports io.leinbach.pubg.data.dao;

    exports io.leinbach.pubg.data.entity to ingester.domain, spring.data.commons;

    opens io.leinbach.pubg.data.config to spring.core, spring.context, spring.beans;
    opens io.leinbach.pubg.data.dao to spring.core, spring.context, spring.beans;
    opens io.leinbach.pubg.data.entity to spring.core, spring.context, spring.beans;
}