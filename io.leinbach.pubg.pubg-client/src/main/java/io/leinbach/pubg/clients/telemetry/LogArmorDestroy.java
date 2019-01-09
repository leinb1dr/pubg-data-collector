package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogArmorDestroy extends LogPlayerTakeDamage {
    @JsonProperty("item")
    private final Item item;

    public LogArmorDestroy(LocalDateTime eventTimestamp, EventType eventType, TelemetryCommon common, int attackId, Character attacker, Character victim, DamageTypeCategory damageTypeCategory, DamageReason damageReason, DamageCauserName damageCauserName, Item item, double distance) {
        super(eventTimestamp, eventType, common, attackId, attacker, victim, damageTypeCategory, damageReason, damageCauserName, damageCauserAdditionalInfo, distance);
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogArmorDestroy that = (LogArmorDestroy) o;
        return attackId == that.attackId &&
                Double.compare(that.distance, distance) == 0 &&
                Objects.equals(attacker, that.attacker) &&
                Objects.equals(victim, that.victim) &&
                damageTypeCategory == that.damageTypeCategory &&
                damageReason == that.damageReason &&
                damageCauserName == that.damageCauserName &&
                Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attackId, attacker, victim, damageTypeCategory, damageReason, damageCauserName, item, distance);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LogArmorDestroy.class.getSimpleName() + "[", "]")
                .add("attackId=" + attackId)
                .add("attacker=" + attacker)
                .add("victim=" + victim)
                .add("damageTypeCategory=" + damageTypeCategory)
                .add("damageReason=" + damageReason)
                .add("damageCauserName=" + damageCauserName)
                .add("item=" + item)
                .add("distance=" + distance)
                .add("eventTimestamp=" + eventTimestamp)
                .add("eventType=" + eventType)
                .add("common=" + common)
                .toString();
    }
}
