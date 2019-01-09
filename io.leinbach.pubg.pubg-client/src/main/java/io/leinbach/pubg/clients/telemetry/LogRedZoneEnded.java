package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class LogRedZoneEnded extends TelemetryBase {
    @JsonProperty("drivers")
    private final List<Character> drivers;

    public LogRedZoneEnded(LocalDateTime eventTimestamp, EventType eventType, TelemetryCommon common, List<Character> drivers) {
        super(eventTimestamp, eventType, common);
        this.drivers = drivers;
    }

    public List<Character> getDrivers() {
        return drivers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LogRedZoneEnded that = (LogRedZoneEnded) o;
        return Objects.equals(drivers, that.drivers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), drivers);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LogRedZoneEnded.class.getSimpleName() + "[", "]")
                .add("drivers=" + drivers)
                .add("eventTimestamp=" + eventTimestamp)
                .add("eventType=" + eventType)
                .add("common=" + common)
                .toString();
    }
}
