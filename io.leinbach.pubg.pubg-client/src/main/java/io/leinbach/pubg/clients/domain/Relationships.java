package io.leinbach.pubg.clients.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;


/**
 * References to resource objects related to this player
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Relationships {

    @JsonProperty("assets")
    private DataList<Map<String, Object>> assets;
    /**
     * A list of match ids.
     */
    @JsonProperty("matches")
    @JsonPropertyDescription("A list of match ids.")
    private DataList<Match> matches;

    @Override
    public String toString() {
        return new StringJoiner(", ", Relationships.class.getSimpleName() + "[", "]")
                .add("assets=" + assets)
                .add("matches=" + matches)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Relationships that = (Relationships) o;
        return Objects.equals(assets, that.assets) &&
                Objects.equals(matches, that.matches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assets, matches);
    }

    public DataList<Map<String, Object>> getAssets() {
        return assets;
    }

    public Relationships setAssets(DataList<Map<String, Object>> assets) {
        this.assets = assets;
        return this;
    }

    public DataList<Match> getMatches() {
        return matches;
    }

    public Relationships setMatches(DataList<Match> matches) {
        this.matches = matches;
        return this;
    }
}
