package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.leinbach.pubg.domain.EventDto;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogPlayerOnlyEvent extends TelemetryBase {
    @JsonProperty("character")
    protected Character character;

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    @Override
    public EventDto to() {
        return super.to().character(character.to());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogPlayerOnlyEvent that = (LogPlayerOnlyEvent) o;
        return Objects.equals(character, that.character);
    }

    @Override
    public int hashCode() {
        return Objects.hash(character);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LogPlayerOnlyEvent.class.getSimpleName() + "[", "]")
                .add("character=" + character)
                .toString();
    }
}
