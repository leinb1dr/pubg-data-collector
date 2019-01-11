package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.leinbach.pubg.domain.StatsDto;

import java.util.Objects;
import java.util.StringJoiner;

public class Stats {
    @JsonProperty("killCount")
    private int killCount;
    @JsonProperty("distanceOnFoot")
    private double distanceOnFoot;
    @JsonProperty("distanceOnSwim")
    private double distanceOnSwim;
    @JsonProperty("distanceOnVehicle")
    private double distanceOnVehicle;
    @JsonProperty("distanceOnParachute")
    private double distanceOnParachute;
    @JsonProperty("distanceOnFreefall")
    private double distanceOnFreefall;

    public StatsDto to() {
        return new StatsDto()
                .killCount(killCount)
                .distanceOnFoot(distanceOnFoot)
                .distanceOnSwim(distanceOnSwim)
                .distanceOnVehicle(distanceOnVehicle)
                .distanceOnParachute(distanceOnParachute)
                .distanceOnFreefall(distanceOnFreefall);
    }

    public int getKillCount() {
        return killCount;
    }

    public void setKillCount(int killCount) {
        this.killCount = killCount;
    }

    public double getDistanceOnFoot() {
        return distanceOnFoot;
    }

    public void setDistanceOnFoot(double distanceOnFoot) {
        this.distanceOnFoot = distanceOnFoot;
    }

    public double getDistanceOnSwim() {
        return distanceOnSwim;
    }

    public void setDistanceOnSwim(double distanceOnSwim) {
        this.distanceOnSwim = distanceOnSwim;
    }

    public double getDistanceOnVehicle() {
        return distanceOnVehicle;
    }

    public void setDistanceOnVehicle(double distanceOnVehicle) {
        this.distanceOnVehicle = distanceOnVehicle;
    }

    public double getDistanceOnParachute() {
        return distanceOnParachute;
    }

    public void setDistanceOnParachute(double distanceOnParachute) {
        this.distanceOnParachute = distanceOnParachute;
    }

    public double getDistanceOnFreefall() {
        return distanceOnFreefall;
    }

    public void setDistanceOnFreefall(double distanceOnFreefall) {
        this.distanceOnFreefall = distanceOnFreefall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stats stats = (Stats) o;
        return killCount == stats.killCount &&
                Double.compare(stats.distanceOnFoot, distanceOnFoot) == 0 &&
                Double.compare(stats.distanceOnSwim, distanceOnSwim) == 0 &&
                Double.compare(stats.distanceOnVehicle, distanceOnVehicle) == 0 &&
                Double.compare(stats.distanceOnParachute, distanceOnParachute) == 0 &&
                Double.compare(stats.distanceOnFreefall, distanceOnFreefall) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(killCount, distanceOnFoot, distanceOnSwim, distanceOnVehicle, distanceOnParachute, distanceOnFreefall);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Stats.class.getSimpleName() + "[", "]")
                .add("killCount=" + killCount)
                .add("distanceOnFoot=" + distanceOnFoot)
                .add("distanceOnSwim=" + distanceOnSwim)
                .add("distanceOnVehicle=" + distanceOnVehicle)
                .add("distanceOnParachute=" + distanceOnParachute)
                .add("distanceOnFreefall=" + distanceOnFreefall)
                .toString();
    }
}
