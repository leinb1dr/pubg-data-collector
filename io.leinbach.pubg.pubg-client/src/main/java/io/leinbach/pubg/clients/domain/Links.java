package io.leinbach.pubg.clients.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.Objects;
import java.util.StringJoiner;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Links {

    /**
     * N/A
     */
    @JsonProperty("schema")
    @JsonPropertyDescription("N/A")
    private String schema;
    /**
     * Link to this object
     */
    @JsonProperty("self")
    @JsonPropertyDescription("Link to this object")
    private String self;

    @Override
    public String toString() {
        return new StringJoiner(", ", Links.class.getSimpleName() + "[", "]")
                .add("schema='" + schema + "'")
                .add("self='" + self + "'")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Links links = (Links) o;
        return Objects.equals(schema, links.schema) &&
                Objects.equals(self, links.self);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schema, self);
    }

    public String getSchema() {
        return schema;
    }

    public Links setSchema(String schema) {
        this.schema = schema;
        return this;
    }

    public String getSelf() {
        return self;
    }

    public Links setSelf(String self) {
        this.self = self;
        return this;
    }

}
