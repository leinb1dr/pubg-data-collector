package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogPlayerPosition extends LogPlayerOnlyEvent {
    @JsonProperty("vehicle")
    private final Vehicle vehicle;
    @JsonProperty("elapsedTime")
    private final double elapsedTime;
    @JsonProperty("numAlivePlayers")
    private final int numAlivePlayers;

    public LogPlayerPosition(LocalDateTime eventTimestamp, EventType eventType, TelemetryCommon common, Character character, Vehicle vehicle, double elapsedTime, int numAlivePlayers) {
        super(eventTimestamp, eventType, common, character);
        this.vehicle = vehicle;
        this.elapsedTime = elapsedTime;
        this.numAlivePlayers = numAlivePlayers;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public double getElapsedTime() {
        return elapsedTime;
    }

    public int getNumAlivePlayers() {
        return numAlivePlayers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LogPlayerPosition that = (LogPlayerPosition) o;
        return Double.compare(that.elapsedTime, elapsedTime) == 0 &&
                numAlivePlayers == that.numAlivePlayers &&
                Objects.equals(vehicle, that.vehicle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), vehicle, elapsedTime, numAlivePlayers);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LogPlayerPosition.class.getSimpleName() + "[", "]")
                .add("vehicle=" + vehicle)
                .add("elapsedTime=" + elapsedTime)
                .add("numAlivePlayers=" + numAlivePlayers)
                .add("character=" + character)
                .add("eventTimestamp=" + eventTimestamp)
                .add("eventType=" + eventType)
                .add("common=" + common)
                .toString();
    }
}
