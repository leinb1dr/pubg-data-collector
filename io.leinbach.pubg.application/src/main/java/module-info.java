/**
 * @author leinb
 * @since 12/26/2018
 */
module pubg.application {
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.webflux;

    requires spring.amqp;

    requires java.sql;

    requires spring.context;

    requires pubg.ingestor.rest;
    requires pubg.ingestor.consumer;

    opens io.leinbach.pubg.ingestor to spring.boot, spring.core, spring.beans, spring.context;
}