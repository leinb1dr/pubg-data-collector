/**
 * @author leinb
 * @since 1/5/2019
 */
module leinbach.pubg.ingestor.domain {
    requires jackson.annotations;

    exports io.leinbach.pubg.domain;

    opens io.leinbach.pubg.domain to com.fasterxml.jackson.databind;

}