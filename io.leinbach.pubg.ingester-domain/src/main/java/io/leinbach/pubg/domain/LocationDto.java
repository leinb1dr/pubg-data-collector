package io.leinbach.pubg.domain;

import java.util.StringJoiner;

/**
 * @author leinb
 * @since 1/9/2019
 */
public class LocationDto {
    private double x;
    private double y;
    private double z;

    public double getX() {
        return x;
    }

    public LocationDto x(double x) {
        this.x = x;
        return this;
    }

    public double getY() {
        return y;
    }

    public LocationDto y(double y) {
        this.y = y;
        return this;
    }

    public double getZ() {
        return z;
    }

    public LocationDto z(double z) {
        this.z = z;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LocationDto.class.getSimpleName() + "[", "]")
                .add("x=" + x)
                .add("y=" + y)
                .add("z=" + z)
                .toString();
    }
}
