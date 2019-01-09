package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogHeal extends LogPlayerOnlyEvent {
    @JsonProperty("item")
    private final Item item;
    @JsonProperty("healAmount")
    private final double healAmount;

    public LogHeal(LocalDateTime eventTimestamp, EventType eventType, TelemetryCommon common, Character character, Item item, double healAmount) {
        super(eventTimestamp, eventType, common, character);
        this.item = item;
        this.healAmount = healAmount;
    }

    public Item getItem() {
        return item;
    }

    public double getHealAmount() {
        return healAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogHeal logHeal = (LogHeal) o;
        return Double.compare(logHeal.healAmount, healAmount) == 0 &&
                Objects.equals(character, logHeal.character) &&
                Objects.equals(item, logHeal.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(character, item, healAmount);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LogHeal.class.getSimpleName() + "[", "]")
                .add("character=" + character)
                .add("item=" + item)
                .add("healAmount=" + healAmount)
                .add("eventTimestamp=" + eventTimestamp)
                .add("eventType=" + eventType)
                .add("common=" + common)
                .toString();
    }
}
