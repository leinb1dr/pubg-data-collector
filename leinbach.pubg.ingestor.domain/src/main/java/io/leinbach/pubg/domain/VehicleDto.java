package io.leinbach.pubg.domain;

import java.util.StringJoiner;

/**
 * @author leinb
 * @since 1/9/2019
 */
public class VehicleDto {
    private String vehicleType;
    private String vehicleId;
    private double healthPercentage;
    private double fuelPercentage;
    private int seatIndex;

    public int getSeatIndex() {
        return seatIndex;
    }

    public VehicleDto seatIndex(int seatIndex) {
        this.seatIndex = seatIndex;
        return this;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public VehicleDto vehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
        return this;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public VehicleDto vehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
        return this;
    }

    public double getHealthPercentage() {
        return healthPercentage;
    }

    public VehicleDto healthPercentage(double healthPercentage) {
        this.healthPercentage = healthPercentage;
        return this;
    }

    public double getFuelPercentage() {
        return fuelPercentage;
    }

    public VehicleDto fuelPercentage(double fuelPercentage) {
        this.fuelPercentage = fuelPercentage;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", VehicleDto.class.getSimpleName() + "[", "]")
                .add("vehicleType='" + vehicleType + "'")
                .add("vehicleId='" + vehicleId + "'")
                .add("healthPercentage=" + healthPercentage)
                .add("fuelPercentage=" + fuelPercentage)
                .add("seatIndex=" + seatIndex)
                .toString();
    }
}
