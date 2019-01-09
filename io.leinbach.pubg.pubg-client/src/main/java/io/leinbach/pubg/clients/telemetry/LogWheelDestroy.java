package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogWheelDestroy extends TelemetryBase {
    @JsonProperty("attackId")
    protected final int attackId;
    @JsonProperty("attacker")
    protected final Character attacker;
    @JsonProperty("vehicle")
    protected final Vehicle vehicle;
    @JsonProperty("damageTypeCategory")
    protected final DamageTypeCategory damageTypeCategory;
    @JsonProperty("damageCauserName")
    protected final DamageCauserName damageCauserName;

    public LogWheelDestroy(LocalDateTime eventTimestamp, EventType eventType, TelemetryCommon common, int attackId, Character attacker, Vehicle vehicle, DamageTypeCategory damageTypeCategory, DamageCauserName damageCauserName) {
        super(eventTimestamp, eventType, common);
        this.attackId = attackId;
        this.attacker = attacker;
        this.vehicle = vehicle;
        this.damageTypeCategory = damageTypeCategory;
        this.damageCauserName = damageCauserName;
    }

    public int getAttackId() {
        return attackId;
    }

    public Character getAttacker() {
        return attacker;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public DamageTypeCategory getDamageTypeCategory() {
        return damageTypeCategory;
    }

    public DamageCauserName getDamageCauserName() {
        return damageCauserName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LogWheelDestroy that = (LogWheelDestroy) o;
        return attackId == that.attackId &&
                Objects.equals(attacker, that.attacker) &&
                Objects.equals(vehicle, that.vehicle) &&
                damageTypeCategory == that.damageTypeCategory &&
                damageCauserName == that.damageCauserName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), attackId, attacker, vehicle, damageTypeCategory, damageCauserName);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LogWheelDestroy.class.getSimpleName() + "[", "]")
                .add("attackId=" + attackId)
                .add("attacker=" + attacker)
                .add("vehicle=" + vehicle)
                .add("damageTypeCategory=" + damageTypeCategory)
                .add("damageCauserName=" + damageCauserName)
                .add("eventTimestamp=" + eventTimestamp)
                .add("eventType=" + eventType)
                .add("common=" + common)
                .toString();
    }
}
