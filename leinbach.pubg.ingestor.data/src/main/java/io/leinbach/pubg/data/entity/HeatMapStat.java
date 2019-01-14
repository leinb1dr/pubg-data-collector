package io.leinbach.pubg.data.entity;

import io.leinbach.pubg.domain.HeatMapStatsDto;

/**
 * @author leinb
 * @since 1/14/2019
 */
public class HeatMapStat {
    private String damageReason;
    private double averageDamage;
    private double totalDamage;
    private int attackCount;

    public HeatMapStat(String damageReason, double averageDamage, double totalDamage, int attackCount) {
        this.damageReason = damageReason;
        this.averageDamage = averageDamage;
        this.totalDamage = totalDamage;
        this.attackCount = attackCount;
    }

    public String getDamageReason() {
        return damageReason;
    }

    public HeatMapStat damageReason(String damageReason) {
        this.damageReason = damageReason;
        return this;
    }

    public double getAverageDamage() {
        return averageDamage;
    }

    public HeatMapStat averageDamage(double averageDamage) {
        this.averageDamage = averageDamage;
        return this;
    }

    public double getTotalDamage() {
        return totalDamage;
    }

    public HeatMapStat totalDamage(double totalDamage) {
        this.totalDamage = totalDamage;
        return this;
    }

    public int getAttackCount() {
        return attackCount;
    }

    public HeatMapStat attackCount(int attackCount) {
        this.attackCount = attackCount;
        return this;
    }

    public HeatMapStatsDto to() {
        return new HeatMapStatsDto()
                .aveDamage(averageDamage)
                .sumDamage(totalDamage)
                .countOfAttacks(attackCount);
    }
}
