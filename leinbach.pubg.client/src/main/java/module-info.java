/**
 * @author leinb
 * @since 12/25/2018
 */
module leinbach.pubg.client {

    requires spring.webflux;
    requires spring.boot;
    requires spring.context;
    requires spring.web;

    requires java.annotation;
    requires com.fasterxml.jackson.databind;
    requires jackson.annotations;
    requires reactor.core;
    requires org.reactivestreams;
    requires slf4j.api;

    requires leinbach.pubg.ingestor.domain;
    requires com.fasterxml.jackson.core;

    exports io.leinbach.pubg.clients.domain to com.fasterxml.jackson.databind;
    exports io.leinbach.pubg.clients;
    exports io.leinbach.pubg.config to leinbach.pubg.application;

    opens io.leinbach.pubg.clients.domain to spring.core, com.fasterxml.jackson.databind;
    opens io.leinbach.pubg.clients.telemetry to spring.core, com.fasterxml.jackson.databind;
    opens io.leinbach.pubg.clients to spring.core;
    opens io.leinbach.pubg.config to spring.boot, spring.core, spring.beans, spring.context;
}