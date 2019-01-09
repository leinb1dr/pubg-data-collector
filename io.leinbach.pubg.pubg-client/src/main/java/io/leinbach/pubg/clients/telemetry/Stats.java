package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.StringJoiner;

public class Stats {
    @JsonProperty("killCount")
    private final int killCount;
    @JsonProperty("distanceOnFoot")
    private final double distanceOnFoot;
    @JsonProperty("distanceOnSwim")
    private final double distanceOnSwim;
    @JsonProperty("distanceOnVehicle")
    private final double distanceOnVehicle;
    @JsonProperty("distanceOnParachute")
    private final double distanceOnParachute;
    @JsonProperty("distanceOnFreefall")
    private final double distanceOnFreefall;

    public Stats(int killCount, double distanceOnFoot, double distanceOnSwim, double distanceOnVehicle, double distanceOnParachute, double distanceOnFreefall) {
        this.killCount = killCount;
        this.distanceOnFoot = distanceOnFoot;
        this.distanceOnSwim = distanceOnSwim;
        this.distanceOnVehicle = distanceOnVehicle;
        this.distanceOnParachute = distanceOnParachute;
        this.distanceOnFreefall = distanceOnFreefall;
    }

    public int getKillCount() {
        return killCount;
    }

    public double getDistanceOnFoot() {
        return distanceOnFoot;
    }

    public double getDistanceOnSwim() {
        return distanceOnSwim;
    }

    public double getDistanceOnVehicle() {
        return distanceOnVehicle;
    }

    public double getDistanceOnParachute() {
        return distanceOnParachute;
    }

    public double getDistanceOnFreefall() {
        return distanceOnFreefall;
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
