package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.leinbach.pubg.domain.EventDto;
import io.leinbach.pubg.domain.ItemDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class LogArmorDestroy extends LogPlayerTakeDamage {

    @JsonProperty("item")
    private Item item;

    @Override
    public EventDto to() {
        return super.to()
                .item(item.to());
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
