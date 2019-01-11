package io.leinbach.pubg.domain;

import java.util.StringJoiner;

/**
 * @author leinb
 * @since 1/9/2019
 */
public class StatsDto {
    private int killCount;
    private double distanceOnFoot;
    private double distanceOnSwim;
    private double distanceOnVehicle;
    private double distanceOnParachute;
    private double distanceOnFreefall;

    public int getKillCount() {
        return killCount;
    }

    public StatsDto killCount(int killCount) {
        this.killCount = killCount;
        return this;
    }

    public double getDistanceOnFoot() {
        return distanceOnFoot;
    }

    public StatsDto distanceOnFoot(double distanceOnFoot) {
        this.distanceOnFoot = distanceOnFoot;
        return this;
    }

    public double getDistanceOnSwim() {
        return distanceOnSwim;
    }

    public StatsDto distanceOnSwim(double distanceOnSwim) {
        this.distanceOnSwim = distanceOnSwim;
        return this;
    }

    public double getDistanceOnVehicle() {
        return distanceOnVehicle;
    }

    public StatsDto distanceOnVehicle(double distanceOnVehicle) {
        this.distanceOnVehicle = distanceOnVehicle;
        return this;
    }

    public double getDistanceOnParachute() {
        return distanceOnParachute;
    }

    public StatsDto distanceOnParachute(double distanceOnParachute) {
        this.distanceOnParachute = distanceOnParachute;
        return this;
    }

    public double getDistanceOnFreefall() {
        return distanceOnFreefall;
    }

    public StatsDto distanceOnFreefall(double distanceOnFreefall) {
        this.distanceOnFreefall = distanceOnFreefall;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StatsDto.class.getSimpleName() + "[", "]")
                .add("killCount=" + killCount)
                .add("distanceOnFoot=" + distanceOnFoot)
                .add("distanceOnSwim=" + distanceOnSwim)
                .add("distanceOnVehicle=" + distanceOnVehicle)
                .add("distanceOnParachute=" + distanceOnParachute)
                .add("distanceOnFreefall=" + distanceOnFreefall)
                .toString();
    }
}
