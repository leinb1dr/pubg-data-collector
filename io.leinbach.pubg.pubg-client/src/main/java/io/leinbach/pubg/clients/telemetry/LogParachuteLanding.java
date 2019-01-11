package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.leinbach.pubg.domain.EventDto;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogParachuteLanding extends LogPlayerOnlyEvent {
    @JsonProperty("distance")
    private double distance;

    @Override
    public EventDto to() {
        return super.to()
                .distance(distance);
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
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
