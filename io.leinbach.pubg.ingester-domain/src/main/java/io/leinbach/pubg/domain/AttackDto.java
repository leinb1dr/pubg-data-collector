package io.leinbach.pubg.domain;

import java.util.List;
import java.util.StringJoiner;

/**
 * @author leinb
 * @since 1/9/2019
 */
public class AttackDto {
    private String damageTypeCategory;
    private String damageReason;
    private String damageCauserName;
    private String damageCauserType;
    private String attackType;
    private double distance;
    private List<String> damageCauserAdditionalInfo;
    private int fireWeaponStackCount;

    public int getFireWeaponStackCount() {
        return fireWeaponStackCount;
    }

    public AttackDto fireWeaponStackCount(int fireWeaponStackCount) {
        this.fireWeaponStackCount = fireWeaponStackCount;
        return this;
    }

    public String getAttackType() {
        return attackType;
    }

    public AttackDto attackType(String attackType) {
        this.attackType = attackType;
        return this;
    }

    public String getDamageTypeCategory() {
        return damageTypeCategory;
    }

    public AttackDto damageTypeCategory(String damageTypeCategory) {
        this.damageTypeCategory = damageTypeCategory;
        return this;
    }

    public String getDamageReason() {
        return damageReason;
    }

    public AttackDto damageReason(String damageReason) {
        this.damageReason = damageReason;
        return this;
    }

    public String getDamageCauserName() {
        return damageCauserName;
    }

    public AttackDto damageCauserName(String damageCauserName) {
        this.damageCauserName = damageCauserName;
        return this;
    }

    public String getDamageCauserType() {
        return damageCauserType;
    }

    public AttackDto damageCauserType(String damageCauserType) {
        this.damageCauserType = damageCauserType;
        return this;
    }

    public double getDistance() {
        return distance;
    }

    public AttackDto distance(double distance) {
        this.distance = distance;
        return this;
    }

    public List<String> getDamageCauserAdditionalInfo() {
        return damageCauserAdditionalInfo;
    }

    public AttackDto damageCauserAdditionalInfo(List<String> damageCauserAdditionalInfo) {
        this.damageCauserAdditionalInfo = damageCauserAdditionalInfo;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AttackDto.class.getSimpleName() + "[", "]")
                .add("damageTypeCategory='" + damageTypeCategory + "'")
                .add("damageReason='" + damageReason + "'")
                .add("damageCauserName='" + damageCauserName + "'")
                .add("damageCauserType='" + damageCauserType + "'")
                .add("attackType='" + attackType + "'")
                .add("distance=" + distance)
                .add("damageCauserAdditionalInfo=" + damageCauserAdditionalInfo)
                .add("fireWeaponStackCount=" + fireWeaponStackCount)
                .toString();
    }
}
