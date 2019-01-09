package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class LogMatchEnd extends TelemetryBase {
    @JsonProperty("characters")
    private final List<Character> characters;

    public LogMatchEnd(LocalDateTime eventTimestamp, EventType eventType, TelemetryCommon common, List<Character> characters) {
        super(eventTimestamp, eventType, common);
        this.characters = characters;
    }

    public List<Character> getCharacters() {
        return characters;
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
