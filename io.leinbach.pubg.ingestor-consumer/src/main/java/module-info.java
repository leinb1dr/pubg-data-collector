/**
 * @author leinb
 * @since 1/6/2019
 */
module pubg.ingestor.consumer {

    requires spring.context;
    requires spring.rabbit;

    requires slf4j.api;

    requires ingester.domain;
    requires pubg.client;
    requires reactor.core;
    requires org.reactivestreams;

    exports io.leinbach.pubg.ingestor.consumer;

    opens io.leinbach.pubg.ingestor.consumer to spring.core, spring.beans, spring.context;

}