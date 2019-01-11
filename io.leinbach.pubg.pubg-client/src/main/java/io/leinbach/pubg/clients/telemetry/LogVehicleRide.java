package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.leinbach.pubg.domain.EventDto;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogVehicleRide extends LogPlayerOnlyEvent {
    @JsonProperty("vehicle")
    private Vehicle vehicle;
    @JsonProperty("seatIndex")
    private int seatIndex;

    @Override
    public EventDto to() {
        return super.to()
                .vehicle(vehicle.to()
                        .seatIndex(seatIndex));
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getSeatIndex() {
        return seatIndex;
    }

    public void setSeatIndex(int seatIndex) {
        this.seatIndex = seatIndex;
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
