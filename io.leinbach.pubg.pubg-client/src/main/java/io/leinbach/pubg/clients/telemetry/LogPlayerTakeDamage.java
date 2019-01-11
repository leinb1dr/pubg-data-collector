package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.leinbach.pubg.domain.AttackDto;
import io.leinbach.pubg.domain.EventDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class LogPlayerTakeDamage extends TelemetryBase {
    @JsonProperty("attackId")
    protected int attackId;
    @JsonProperty("attacker")
    protected Character attacker;
    @JsonProperty("victim")
    protected Character victim;
    @JsonProperty("damageTypeCategory")
    protected DamageTypeCategory damageTypeCategory;
    @JsonProperty("damageReason")
    protected DamageReason damageReason;
    @JsonProperty("damageCauserName")
    protected DamageCauserName damageCauserName;
    @JsonProperty("distance")
    protected double distance;
    @JsonProperty("damageCauserAdditionalInfo")
    protected List<String> damageCauserAdditionalInfo;

    @Override
    public EventDto to() {
        return new EventDto().attackId(attackId)
                .character(attacker != null ? attacker.to() : null)
                .target(victim.to())
                .attack(new AttackDto()
                        .damageCauserAdditionalInfo(damageCauserAdditionalInfo)
                        .damageCauserName(damageCauserName.getKey()
                                .toUpperCase())
                        .damageCauserType(damageCauserName.getName()
                                .toUpperCase())
                        .damageReason(damageReason != null ? damageReason.name() : null)
                        .damageTypeCategory(damageTypeCategory.name())
                );
    }

    public List<String> getDamageCauserAdditionalInfo() {
        return damageCauserAdditionalInfo;
    }

    public void setDamageCauserAdditionalInfo(List<String> damageCauserAdditionalInfo) {
        this.damageCauserAdditionalInfo = damageCauserAdditionalInfo;
    }

    public int getAttackId() {
        return attackId;
    }

    public void setAttackId(int attackId) {
        this.attackId = attackId;
    }

    public Character getAttacker() {
        return attacker;
    }

    public void setAttacker(Character attacker) {
        this.attacker = attacker;
    }

    public Character getVictim() {
        return victim;
    }

    public void setVictim(Character victim) {
        this.victim = victim;
    }

    public DamageTypeCategory getDamageTypeCategory() {
        return damageTypeCategory;
    }

    public void setDamageTypeCategory(DamageTypeCategory damageTypeCategory) {
        this.damageTypeCategory = damageTypeCategory;
    }

    public DamageReason getDamageReason() {
        return damageReason;
    }

    public void setDamageReason(DamageReason damageReason) {
        this.damageReason = damageReason;
    }

    public DamageCauserName getDamageCauserName() {
        return damageCauserName;
    }

    public void setDamageCauserName(DamageCauserName damageCauserName) {
        this.damageCauserName = damageCauserName;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LogPlayerTakeDamage that = (LogPlayerTakeDamage) o;
        return attackId == that.attackId &&
                Double.compare(that.distance, distance) == 0 &&
                Objects.equals(attacker, that.attacker) &&
                Objects.equals(victim, that.victim) &&
                damageTypeCategory == that.damageTypeCategory &&
                damageReason == that.damageReason &&
                damageCauserName == that.damageCauserName &&
                Objects.equals(damageCauserAdditionalInfo, that.damageCauserAdditionalInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), attackId, attacker, victim, damageTypeCategory, damageReason, damageCauserName, damageCauserAdditionalInfo, distance);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LogPlayerTakeDamage.class.getSimpleName() + "[", "]")
                .add("attackId=" + attackId)
                .add("attacker=" + attacker)
                .add("victim=" + victim)
                .add("damageTypeCategory=" + damageTypeCategory)
                .add("damageReason=" + damageReason)
                .add("damageCauserName=" + damageCauserName)
                .add("damageCauserAdditionalInfo=" + damageCauserAdditionalInfo)
                .add("distance=" + distance)
                .add("eventTimestamp=" + eventTimestamp)
                .add("eventType=" + eventType)
                .add("common=" + common)
                .toString();
    }
}
