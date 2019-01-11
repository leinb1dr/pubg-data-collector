package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.leinbach.pubg.domain.AttackDto;
import io.leinbach.pubg.domain.EventDto;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogWheelDestroy extends TelemetryBase {
    @JsonProperty("attackId")
    protected int attackId;
    @JsonProperty("attacker")
    protected Character attacker;
    @JsonProperty("vehicle")
    protected Vehicle vehicle;
    @JsonProperty("damageTypeCategory")
    protected DamageTypeCategory damageTypeCategory;
    @JsonProperty("damageCauserName")
    protected DamageCauserName damageCauserName;

    @Override
    public EventDto to() {
        return new EventDto()
                .attackId(attackId)
                .character(attacker.to())
                .vehicle(vehicle.to())
                .attack(new AttackDto()
                        .damageTypeCategory(damageTypeCategory.name())
                        .damageCauserName(damageCauserName.getKey().toUpperCase())
                        .damageCauserType(damageCauserName.getName().toUpperCase())
                );
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public DamageTypeCategory getDamageTypeCategory() {
        return damageTypeCategory;
    }

    public void setDamageTypeCategory(DamageTypeCategory damageTypeCategory) {
        this.damageTypeCategory = damageTypeCategory;
    }

    public DamageCauserName getDamageCauserName() {
        return damageCauserName;
    }

    public void setDamageCauserName(DamageCauserName damageCauserName) {
        this.damageCauserName = damageCauserName;
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
