package io.leinbach.pubg.clients.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.leinbach.pubg.domain.MatchDto;
import io.leinbach.pubg.domain.PlayerDto;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;


/**
 * Player Object
 * <p>
 * Player objects contain information about a player and a list of their recent matches (up to 14 days old). Note: player objects are specific to platform shards.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PubgPlayer {
    @JsonProperty("type")
    @JsonPropertyDescription("Identifier for this object type (\"player\")")
    private EntityType type;
    /**
     * Player ID
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Player ID")
    private String id;
    @JsonProperty("attributes")
    private Attributes attributes;
    /**
     * References to resource objects related to this player
     */
    @JsonProperty("relationships")
    @JsonPropertyDescription("References to resource objects related to this player")
    private Relationships relationships;
    @JsonProperty("links")
    private Links links;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PubgPlayer pubgPlayer = (PubgPlayer) o;
        return Objects.equals(type, pubgPlayer.type) &&
                Objects.equals(id, pubgPlayer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PubgPlayer.class.getSimpleName() + "[", "]")
                .add("type='" + type + "'")
                .add("id='" + id + "'")
                .add("attributes=" + attributes)
                .add("relationships=" + relationships)
                .add("links=" + links)
                .toString();
    }

    public PlayerDto to() {
        return new PlayerDto()
                .id(id)
                .name(attributes.getName())
                .matches(relationships
                        .getMatches()
                        .getData()
                        .stream()
                        .map(Match::to)
                        .collect(Collectors.toList()));
    }

    public EntityType getType() {
        return type;
    }

    public PubgPlayer setType(EntityType type) {
        this.type = type;
        return this;
    }

    public String getId() {
        return id;
    }

    public PubgPlayer setId(String id) {
        this.id = id;
        return this;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public PubgPlayer setAttributes(Attributes attributes) {
        this.attributes = attributes;
        return this;
    }

    public Relationships getRelationships() {
        return relationships;
    }

    public PubgPlayer setRelationships(Relationships relationships) {
        this.relationships = relationships;
        return this;
    }

    public Links getLinks() {
        return links;
    }

    public PubgPlayer setLinks(Links links) {
        this.links = links;
        return this;
    }

}
