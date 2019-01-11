/**
 * @author leinb
 * @since 1/6/2019
 */
module leinbach.pubg.ingestor.consumer.heatmap {

    requires spring.context;
    requires spring.rabbit;

    requires slf4j.api;

    requires leinbach.pubg.ingestor.domain;
    requires leinbach.pubg.ingestor.data;

    requires reactor.core;
    requires org.reactivestreams;
    requires spring.amqp;

    exports io.leinbach.pubg.ingestor.consumer.heatmap;

    opens io.leinbach.pubg.ingestor.consumer.heatmap to spring.core, spring.beans, spring.context;

}