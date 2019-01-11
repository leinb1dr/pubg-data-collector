package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.leinbach.pubg.domain.EventDto;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogHeal extends LogItemInteract {
    @JsonProperty("healAmount")
    private double healAmount;

    @Override
    public EventDto to() {
        return super.to()
                .healAmount(healAmount);
    }

    public double getHealAmount() {
        return healAmount;
    }

    public void setHealAmount(double healAmount) {
        this.healAmount = healAmount;
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
