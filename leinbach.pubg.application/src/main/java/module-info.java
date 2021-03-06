/**
 * @author leinb
 * @since 12/26/2018
 */
module leinbach.pubg.application {
    requires spring.context;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.web;
    requires spring.webflux;
    requires spring.amqp;

    requires java.sql;
    requires java.annotation;

    requires jackson.annotations;
    requires com.fasterxml.jackson.databind;

    requires leinbach.pubg.ingestor.rest;
    requires leinbach.pubg.ingestor.consumer.match;
    requires leinbach.pubg.ingestor.consumer.heatmap;

    opens io.leinbach.pubg.ingestor to spring.boot, spring.core, spring.beans, spring.context;
}