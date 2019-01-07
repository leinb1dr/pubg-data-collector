/**
 * @author leinb
 * @since 12/25/2018
 */
module pubg.ingestor.rest {
    requires reactor.core;

    requires spring.context;
    requires spring.web;
    requires spring.webflux;
    requires spring.amqp;

    requires jackson.annotations;

    requires org.reactivestreams;

    requires transitive pubg.data;
    requires transitive pubg.client;
    requires ingester.domain;

    exports io.leinbach.pubg.ingestor.controller;

    opens io.leinbach.pubg.ingestor.controller to spring.webflux,spring.core, spring.context, spring.beans;

}