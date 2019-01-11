package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.leinbach.pubg.domain.EventDto;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogPlayerPosition extends LogPlayerOnlyEvent {
    @JsonProperty("vehicle")
    private Vehicle vehicle;
    @JsonProperty("elapsedTime")
    private double elapsedTime;
    @JsonProperty("numAlivePlayers")
    private int numAlivePlayers;

    @Override
    public EventDto to() {
        return super.to()
                .vehicle(vehicle.to())
                .elapsedTime(elapsedTime);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(double elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public int getNumAlivePlayers() {
        return numAlivePlayers;
    }

    public void setNumAlivePlayers(int numAlivePlayers) {
        this.numAlivePlayers = numAlivePlayers;
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
