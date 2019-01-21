package io.leinbach.pubg.clients.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author leinb
 * @since 1/7/2019
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        visible = true,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value=ParticipantEntity.class, name = "participant"),
        @JsonSubTypes.Type(value=RosterEntity.class, name = "roster"),
        @JsonSubTypes.Type(value=AssetEntity.class, name = "asset"),
        @JsonSubTypes.Type(value= PlayerEntity.class, name = "player"),
        @JsonSubTypes.Type(value= MatchEntity.class, name = "match"),
        @JsonSubTypes.Type(value = PlayerSeasonEntity.class, name = "playerSeason")
})
public abstract class PubgEntity<A extends Attributes, R extends Relationships> {
    @JsonProperty("type")
    protected EntityType type;
    @JsonProperty("id")
    protected String id;
    @JsonProperty("attributes")
    protected A attributes;
    @JsonProperty("relationships")
    protected R relationships;
    @JsonProperty("links")
    protected Links links;

    public PubgEntity() {
    }

    public PubgEntity(EntityType type, String id, A attributes, R relationships, Links links) {
        this.type = type;
        this.id = id;
        this.attributes = attributes;
        this.relationships = relationships;
        this.links = links;
    }

    public Links getLinks() {
        return links;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PubgEntity<?, ?> that = (PubgEntity<?, ?>) o;
        return type == that.type &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PubgEntity.class.getSimpleName() + "[", "]")
                .add("type=" + type)
                .add("id='" + id + "'")
                .add("attributes=" + attributes)
                .add("relationships=" + relationships)
                .add("links=" + links)
                .toString();
    }

    public R getRelationships() {
        return relationships;
    }

    public EntityType getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public A getAttributes() {
        return attributes;
    }

    public PubgEntity<A, R> type(EntityType type) {
        this.type = type;
        return this;
    }

    public PubgEntity<A, R> id(String id) {
        this.id = id;
        return this;
    }

    public PubgEntity<A, R> attributes(A attributes) {
        this.attributes = attributes;
        return this;
    }

    public PubgEntity<A, R> relationships(R relationships) {
        this.relationships = relationships;
        return this;
    }

    public PubgEntity<A, R> links(Links links) {
        this.links = links;
        return this;
    }
}
