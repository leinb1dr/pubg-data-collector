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
    requires java.annotation;

    requires spring.context;

    requires spring.web;

    requires com.fasterxml.jackson.module.paramnames;
    requires com.fasterxml.jackson.datatype.jdk8;

    requires pubg.ingestor.rest;
    requires pubg.ingestor.consumer;
    requires jackson.annotations;

    opens io.leinbach.pubg.ingestor to spring.boot, spring.core, spring.beans, spring.context;
}