package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.leinbach.pubg.domain.EventDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class LogMatchEnd extends TelemetryBase {
    @JsonProperty("characters")
    private List<Character> characters;

    @Override
    public EventDto to() {
        return super.to();
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogMatchEnd that = (LogMatchEnd) o;
        return Objects.equals(characters, that.characters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characters);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LogMatchEnd.class.getSimpleName() + "[", "]")
                .add("characters=" + characters)
                .add("eventTimestamp=" + eventTimestamp)
                .add("eventType=" + eventType)
                .add("common=" + common)
                .toString();
    }
}
