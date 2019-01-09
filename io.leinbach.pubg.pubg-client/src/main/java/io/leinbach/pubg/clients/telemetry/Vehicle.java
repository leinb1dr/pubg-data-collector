package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.StringJoiner;

public class Vehicle {
    @JsonProperty("vehicleType")
    private final String vehicleType;
    @JsonProperty("vehicleId")
    private final String vehicleId;
    @JsonProperty("healthPercentage")
    private final double healthPercentage;
    @JsonProperty("feulPercentage")
    private final double fuelPercentage;

    public Vehicle(String vehicleType, String vehicleId, double healthPercentage, double fuelPercentage) {
        this.vehicleType = vehicleType;
        this.vehicleId = vehicleId;
        this.healthPercentage = healthPercentage;
        this.fuelPercentage = fuelPercentage;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public double getHealthPercentage() {
        return healthPercentage;
    }

    public double getFuelPercentage() {
        return fuelPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(vehicle.healthPercentage, healthPercentage) == 0 &&
                Double.compare(vehicle.fuelPercentage, fuelPercentage) == 0 &&
                Objects.equals(vehicleType, vehicle.vehicleType) &&
                Objects.equals(vehicleId, vehicle.vehicleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleType, vehicleId, healthPercentage, fuelPercentage);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vehicle.class.getSimpleName() + "[", "]")
                .add("vehicleType='" + vehicleType + "'")
                .add("vehicleId='" + vehicleId + "'")
                .add("healthPercentage=" + healthPercentage)
                .add("fuelPercentage=" + fuelPercentage)
                .toString();
    }
}
