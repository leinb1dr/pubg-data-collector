package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.leinbach.pubg.domain.AttackDto;
import io.leinbach.pubg.domain.EventDto;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogPlayerAttack extends TelemetryBase {

    @JsonProperty("attackId")
    private int attackId;
    @JsonProperty("fireWeaponStackCount")
    private int fireWeaponStackCount;
    @JsonProperty("attacker")
    private Character attacker;
    @JsonProperty("attackType")
    private String attackType;
    @JsonProperty("weapon")
    private Item weapon;
    @JsonProperty("vehicle")
    private Vehicle vehicle;

    @Override
    public EventDto to() {
        return new EventDto()
                .attackId(attackId)
                .character(attacker.to())
                .item(weapon.to())
                .vehicle(vehicle != null ? vehicle.to() : null)
                .attack(new AttackDto()
                        .attackType(attackType)
                        .fireWeaponStackCount(fireWeaponStackCount));
    }

    public int getAttackId() {
        return attackId;
    }

    public void setAttackId(int attackId) {
        this.attackId = attackId;
    }

    public int getFireWeaponStackCount() {
        return fireWeaponStackCount;
    }

    public void setFireWeaponStackCount(int fireWeaponStackCount) {
        this.fireWeaponStackCount = fireWeaponStackCount;
    }

    public Character getAttacker() {
        return attacker;
    }

    public void setAttacker(Character attacker) {
        this.attacker = attacker;
    }

    public String getAttackType() {
        return attackType;
    }

    public void setAttackType(String attackType) {
        this.attackType = attackType;
    }

    public Item getWeapon() {
        return weapon;
    }

    public void setWeapon(Item weapon) {
        this.weapon = weapon;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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
