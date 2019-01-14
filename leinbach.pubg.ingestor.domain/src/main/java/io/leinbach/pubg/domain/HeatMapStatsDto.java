package io.leinbach.pubg.domain;

/**
 * @author leinb
 * @since 1/14/2019
 */
public class HeatMapStatsDto {
    private double aveDamage;
    private double sumDamage;
    private int countOfAttacks;

    public double getAveDamage() {
        return aveDamage;
    }

    public HeatMapStatsDto aveDamage(double aveDamage) {
        this.aveDamage = aveDamage;
        return this;
    }

    public double getSumDamage() {
        return sumDamage;
    }

    public HeatMapStatsDto sumDamage(double sumDamage) {
        this.sumDamage = sumDamage;
        return this;
    }

    public int getCountOfAttacks() {
        return countOfAttacks;
    }

    public HeatMapStatsDto countOfAttacks(int countOfAttacks) {
        this.countOfAttacks = countOfAttacks;
        return this;
    }
}
