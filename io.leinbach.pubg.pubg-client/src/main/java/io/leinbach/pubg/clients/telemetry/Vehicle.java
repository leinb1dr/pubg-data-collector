package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.leinbach.pubg.domain.VehicleDto;

import java.util.Objects;
import java.util.StringJoiner;

public class Vehicle {
    @JsonProperty("vehicleType")
    private String vehicleType;
    @JsonProperty("vehicleId")
    private String vehicleId;
    @JsonProperty("healthPercentage")
    private double healthPercentage;
    @JsonProperty("feulPercentage")
    private double fuelPercentage;

    public VehicleDto to(){
        return new VehicleDto()
                .vehicleType(vehicleType)
                .vehicleId(vehicleId)
                .healthPercentage(healthPercentage)
                .fuelPercentage(fuelPercentage);
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public double getHealthPercentage() {
        return healthPercentage;
    }

    public void setHealthPercentage(double healthPercentage) {
        this.healthPercentage = healthPercentage;
    }

    public double getFuelPercentage() {
        return fuelPercentage;
    }

    public void setFuelPercentage(double fuelPercentage) {
        this.fuelPercentage = fuelPercentage;
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
