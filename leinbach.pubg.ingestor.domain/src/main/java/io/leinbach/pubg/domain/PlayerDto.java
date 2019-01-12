package io.leinbach.pubg.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author leinb
 * @since 12/27/2018
 */
public class PlayerDto {
    @JsonProperty
    private String name;
    @JsonProperty
    private String id;
    @JsonProperty
    private LocalDateTime lastUpdate;
    private List<MatchDto> matches;

    public PlayerDto() {
    }

    public boolean needsRefresh() {
        return lastUpdate == null || lastUpdate.isBefore(LocalDateTime.now()
                .minusMinutes(5));
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public PlayerDto lastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    public List<MatchDto> getMatches() {
        return matches;
    }

    public PlayerDto matches(List<MatchDto> matches) {
        this.matches = matches;
        return this;
    }

    public String getName() {
        return name;
    }

    public PlayerDto name(String name) {
        this.name = name;
        return this;
    }

    public String getId() {
        return id;
    }

    public PlayerDto id(String id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerDto playerDto = (PlayerDto) o;
        return Objects.equals(name, playerDto.name) &&
                Objects.equals(id, playerDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PlayerDto.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("id='" + id + "'")
                .add("matches=" + matches)
                .toString();
    }
}
