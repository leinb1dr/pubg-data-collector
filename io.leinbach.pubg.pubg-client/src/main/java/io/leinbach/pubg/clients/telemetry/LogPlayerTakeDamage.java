package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class LogPlayerTakeDamage extends TelemetryBase {
    @JsonProperty("attackId")
    protected final int attackId;
    @JsonProperty("attacker")
    protected final Character attacker;
    @JsonProperty("victim")
    protected final Character victim;
    @JsonProperty("damageTypeCategory")
    protected final DamageTypeCategory damageTypeCategory;
    @JsonProperty("damageReason")
    protected final DamageReason damageReason;
    @JsonProperty("damageCauserName")
    protected final DamageCauserName damageCauserName;
    @JsonProperty("distance")
    protected final double distance;
    @JsonProperty("damageCauserAdditionalInfo")
    protected final List<String> damageCauserAdditionalInfo;

    public LogPlayerTakeDamage(LocalDateTime eventTimestamp, EventType eventType, TelemetryCommon common, int attackId, Character attacker, Character victim, DamageTypeCategory damageTypeCategory, DamageReason damageReason, DamageCauserName damageCauserName, List<String> damageCauserAdditionalInfo, double distance) {
        super(eventTimestamp, eventType, common);
        this.attackId = attackId;
        this.attacker = attacker;
        this.victim = victim;
        this.damageTypeCategory = damageTypeCategory;
        this.damageReason = damageReason;
        this.damageCauserName = damageCauserName;
        this.damageCauserAdditionalInfo = damageCauserAdditionalInfo;
        this.distance = distance;
    }

    public List<String> getDamageCauserAdditionalInfo() {
        return damageCauserAdditionalInfo;
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

    public int getAttackId() {
        return attackId;
    }

    public Character getAttacker() {
        return attacker;
    }

    public Character getVictim() {
        return victim;
    }

    public DamageTypeCategory getDamageTypeCategory() {
        return damageTypeCategory;
    }

    public DamageReason getDamageReason() {
        return damageReason;
    }

    public DamageCauserName getDamageCauserName() {
        return damageCauserName;
    }

    public double getDistance() {
        return distance;
    }
}
