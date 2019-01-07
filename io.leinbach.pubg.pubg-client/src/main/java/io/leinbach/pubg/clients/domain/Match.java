package io.leinbach.pubg.clients.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.leinbach.pubg.domain.MatchDto;

import java.util.Objects;
import java.util.StringJoiner;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Match {

    public MatchDto to() {
        return new MatchDto(id, type.name());
    }

    /**
     * Match ID - Used to lookup the full match object on the /matches endpoint
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Match ID - Used to lookup the full match object on the /matches endpoint")
    private String id;
    /**
     * Identifier for this object type ("match")
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Identifier for this object type (\"match\")")
    private EntityType type;

    @Override
    public String toString() {
        return new StringJoiner(", ", Match.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("type='" + type + "'")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return Objects.equals(id, match.id) &&
                Objects.equals(type, match.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    public String getId() {
        return id;
    }

    public Match setId(String id) {
        this.id = id;
        return this;
    }

    public EntityType getType() {
        return type;
    }

    public Match setType(EntityType type) {
        this.type = type;
        return this;
    }

}
