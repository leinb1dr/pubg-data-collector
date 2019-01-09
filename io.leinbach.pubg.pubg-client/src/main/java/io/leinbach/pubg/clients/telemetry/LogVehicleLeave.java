package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogVehicleLeave extends LogVehicleRide {
    @JsonProperty("rideDistance")
    private final double rideDistance;
    @JsonProperty("maxSpeed")
    private final double maxSpeed;

    public LogVehicleLeave(LocalDateTime eventTimestamp, EventType eventType, TelemetryCommon common, Character character, Vehicle vehicle, int seatIndex, double rideDistance, double maxSpeed) {
        super(eventTimestamp, eventType, common, character, vehicle, seatIndex);
        this.rideDistance = rideDistance;
        this.maxSpeed = maxSpeed;
    }

    public double getRideDistance() {
        return rideDistance;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LogVehicleLeave that = (LogVehicleLeave) o;
        return Double.compare(that.rideDistance, rideDistance) == 0 &&
                Double.compare(that.maxSpeed, maxSpeed) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rideDistance, maxSpeed);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LogVehicleLeave.class.getSimpleName() + "[", "]")
                .add("rideDistance=" + rideDistance)
                .add("maxSpeed=" + maxSpeed)
                .add("character=" + character)
                .add("eventTimestamp=" + eventTimestamp)
                .add("eventType=" + eventType)
                .add("common=" + common)
                .toString();
    }
}
