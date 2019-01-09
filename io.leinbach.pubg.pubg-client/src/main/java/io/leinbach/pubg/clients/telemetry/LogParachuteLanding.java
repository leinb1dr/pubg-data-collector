package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogParachuteLanding extends LogPlayerOnlyEvent {
    @JsonProperty("distance")
    private final double distance;

    public LogParachuteLanding(LocalDateTime eventTimestamp, EventType eventType, TelemetryCommon common, Character character, double distance) {
        super(eventTimestamp, eventType, common, character);
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LogParachuteLanding that = (LogParachuteLanding) o;
        return Double.compare(that.distance, distance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), distance);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LogParachuteLanding.class.getSimpleName() + "[", "]")
                .add("distance=" + distance)
                .add("character=" + character)
                .add("eventTimestamp=" + eventTimestamp)
                .add("eventType=" + eventType)
                .add("common=" + common)
                .toString();
    }
}
