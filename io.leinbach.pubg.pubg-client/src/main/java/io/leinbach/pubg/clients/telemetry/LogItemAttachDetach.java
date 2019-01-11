package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.leinbach.pubg.domain.EventDto;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogItemAttachDetach extends LogPlayerOnlyEvent {
    @JsonProperty("parentItem")
    private Item parentItem;
    @JsonProperty("childItem")
    private Item childItem;

    @Override
    public EventDto to() {
        return super.to()
                .item(parentItem.to())
                .attachment((childItem.to()));
    }

    public Item getParentItem() {
        return parentItem;
    }

    public void setParentItem(Item parentItem) {
        this.parentItem = parentItem;
    }

    public Item getChildItem() {
        return childItem;
    }

    public void setChildItem(Item childItem) {
        this.childItem = childItem;
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
