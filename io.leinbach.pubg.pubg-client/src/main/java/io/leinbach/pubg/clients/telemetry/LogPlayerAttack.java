package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogPlayerAttack extends TelemetryBase {

    @JsonProperty("attackId")
    private final int attackId;
    @JsonProperty("fireWeaponStackCount")
    private final int fireWeaponStackCount;
    @JsonProperty("attacker")
    private final Character attacker;
    @JsonProperty("attackType")
    private final String attackType;
    @JsonProperty("weapon")
    private final Item weapon;
    @JsonProperty("vehicle")
    private final Vehicle vehicle;

    public LogPlayerAttack(LocalDateTime eventTimestamp, EventType eventType, TelemetryCommon common, int attackId, int fireWeaponStackCount, Character attacker, String attackType, Item weapon, Vehicle vehicle) {
        super(eventTimestamp, eventType, common);
        this.attackId = attackId;
        this.fireWeaponStackCount = fireWeaponStackCount;
        this.attacker = attacker;
        this.attackType = attackType;
        this.weapon = weapon;
        this.vehicle = vehicle;
    }

    public int getAttackId() {
        return attackId;
    }

    public int getFireWeaponStackCount() {
        return fireWeaponStackCount;
    }

    public Character getAttacker() {
        return attacker;
    }

    public String getAttackType() {
        return attackType;
    }

    public Item getWeapon() {
        return weapon;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LogPlayerAttack that = (LogPlayerAttack) o;
        return attackId == that.attackId &&
                fireWeaponStackCount == that.fireWeaponStackCount &&
                Objects.equals(attacker, that.attacker) &&
                Objects.equals(attackType, that.attackType) &&
                Objects.equals(weapon, that.weapon) &&
                Objects.equals(vehicle, that.vehicle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), attackId, fireWeaponStackCount, attacker, attackType, weapon, vehicle);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LogPlayerAttack.class.getSimpleName() + "[", "]")
                .add("attackId=" + attackId)
                .add("fireWeaponStackCount=" + fireWeaponStackCount)
                .add("attacker=" + attacker)
                .add("attackType='" + attackType + "'")
                .add("weapon=" + weapon)
                .add("vehicle=" + vehicle)
                .add("eventTimestamp=" + eventTimestamp)
                .add("eventType=" + eventType)
                .add("common=" + common)
                .toString();
    }
}
