package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogVehicleRide extends LogPlayerOnlyEvent {
    @JsonProperty("vehicle")
    private final Vehicle vehicle;
    @JsonProperty("seatIndex")
    private final int seatIndex;

    public LogVehicleRide(LocalDateTime eventTimestamp, EventType eventType, TelemetryCommon common, Character character, Vehicle vehicle, int seatIndex) {
        super(eventTimestamp, eventType, common, character);
        this.vehicle = vehicle;
        this.seatIndex = seatIndex;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getSeatIndex() {
        return seatIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LogVehicleRide that = (LogVehicleRide) o;
        return seatIndex == that.seatIndex &&
                Objects.equals(vehicle, that.vehicle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), vehicle, seatIndex);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LogVehicleRide.class.getSimpleName() + "[", "]")
                .add("vehicle=" + vehicle)
                .add("seatIndex=" + seatIndex)
                .add("character=" + character)
                .add("eventTimestamp=" + eventTimestamp)
                .add("eventType=" + eventType)
                .add("common=" + common)
                .toString();
    }
}
