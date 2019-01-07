/**
 * @author leinb
 * @since 12/25/2018
 */
module pubg.client {

    requires spring.webflux;
    requires spring.boot;
    requires spring.context;
    requires jackson.annotations;
    requires reactor.core;
    requires org.reactivestreams;
    requires spring.web;

    requires ingester.domain;

    exports io.leinbach.pubg.clients.domain to com.fasterxml.jackson.databind;
    exports io.leinbach.pubg.clients;
    exports io.leinbach.pubg.config to pubg.application ;

    opens io.leinbach.pubg.clients.domain to spring.core;
    opens io.leinbach.pubg.clients to spring.core;
    opens io.leinbach.pubg.config to spring.boot, spring.core, spring.beans, spring.context;
}