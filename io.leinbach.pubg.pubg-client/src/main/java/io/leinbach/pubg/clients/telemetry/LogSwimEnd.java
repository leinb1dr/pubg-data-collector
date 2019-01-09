package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogSwimEnd extends LogPlayerOnlyEvent {
    @JsonProperty("swimDistance")
    private final double swimDistance;
    @JsonProperty("maxSwimDepthOfWater")
    private final double maxSwimDepthOfWater;

    public LogSwimEnd(LocalDateTime eventTimestamp, EventType eventType, TelemetryCommon common, Character character, double swimDistance, double maxSwimDepthOfWater) {
        super(eventTimestamp, eventType, common, character);
        this.swimDistance = swimDistance;
        this.maxSwimDepthOfWater = maxSwimDepthOfWater;
    }

    public double getSwimDistance() {
        return swimDistance;
    }

    public double getMaxSwimDepthOfWater() {
        return maxSwimDepthOfWater;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LogSwimEnd that = (LogSwimEnd) o;
        return Double.compare(that.swimDistance, swimDistance) == 0 &&
                Double.compare(that.maxSwimDepthOfWater, maxSwimDepthOfWater) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), swimDistance, maxSwimDepthOfWater);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LogSwimEnd.class.getSimpleName() + "[", "]")
                .add("swimDistance=" + swimDistance)
                .add("maxSwimDepthOfWater=" + maxSwimDepthOfWater)
                .add("character=" + character)
                .add("eventTimestamp=" + eventTimestamp)
                .add("eventType=" + eventType)
                .add("common=" + common)
                .toString();
    }
}
