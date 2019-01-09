package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogItemAttachDetach extends LogPlayerOnlyEvent {
    @JsonProperty("parentItem")
    private final Item parentItem;
    @JsonProperty("childItem")
    private final Item childItem;

    public LogItemAttachDetach(LocalDateTime eventTimestamp, EventType eventType, TelemetryCommon common, Character character, Item parentItem, Item childItem) {
        super(eventTimestamp, eventType, common, character);
        this.parentItem = parentItem;
        this.childItem = childItem;
    }

    public Item getParentItem() {
        return parentItem;
    }

    public Item getChildItem() {
        return childItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogItemAttachDetach that = (LogItemAttachDetach) o;
        return Objects.equals(character, that.character) &&
                Objects.equals(parentItem, that.parentItem) &&
                Objects.equals(childItem, that.childItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(character, parentItem, childItem);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LogItemAttachDetach.class.getSimpleName() + "[", "]")
                .add("character=" + character)
                .add("parentItem=" + parentItem)
                .add("childItem=" + childItem)
                .add("eventTimestamp=" + eventTimestamp)
                .add("eventType=" + eventType)
                .add("common=" + common)
                .toString();
    }
}
