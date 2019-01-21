/**
 * @author leinb
 * @since 12/25/2018
 */
module leinbach.pubg.ingestor.rest {
    requires reactor.core;

    requires spring.context;
    requires spring.web;
    requires spring.webflux;
    requires spring.amqp;

    requires jackson.annotations;

    requires org.reactivestreams;

    requires transitive leinbach.pubg.ingestor.data;
    requires transitive leinbach.pubg.client;
    requires leinbach.pubg.ingestor.domain;

    exports io.leinbach.pubg.ingestor.controller;
    exports io.leinbach.pubg.ingestor.controller.util to spring.beans;

    opens io.leinbach.pubg.ingestor.controller to spring.webflux,spring.core, spring.context, spring.beans;

}