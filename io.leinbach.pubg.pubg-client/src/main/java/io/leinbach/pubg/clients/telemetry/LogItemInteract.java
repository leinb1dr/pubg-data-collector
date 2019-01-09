package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogItemInteract extends LogPlayerOnlyEvent {
    @JsonProperty("item")
    private final Item item;
    @JsonProperty("ownerTeamId")
    private final int ownerTeamId;

    public LogItemInteract(LocalDateTime eventTimestamp, EventType eventType, TelemetryCommon common, Character character, Item item, int ownerTeamId) {
        super(eventTimestamp, eventType, common,character);
        this.item = item;
        this.ownerTeamId = ownerTeamId;
    }

    public int getOwnerTeamId() {
        return ownerTeamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogItemInteract that = (LogItemInteract) o;
        return ownerTeamId == that.ownerTeamId &&
                Objects.equals(character, that.character) &&
                Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(character, item, ownerTeamId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LogItemInteract.class.getSimpleName() + "[", "]")
                .add("character=" + character)
                .add("item=" + item)
                .add("ownerTeamId=" + ownerTeamId)
                .add("eventTimestamp=" + eventTimestamp)
                .add("eventType=" + eventType)
                .add("common=" + common)
                .toString();
    }

    public Item getItem() {
        return item;
    }

}
