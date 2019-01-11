package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.leinbach.pubg.domain.EventDto;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogItemInteract extends LogPlayerOnlyEvent {
    @JsonProperty("item")
    protected Item item;
    @JsonProperty("ownerTeamId")
    protected int ownerTeamId;

    @Override
    public EventDto to() {
        return super.to()
                .item(item.to())
                .ownerTeamId(ownerTeamId);
    }

    public int getOwnerTeamId() {
        return ownerTeamId;
    }

    public void setOwnerTeamId(int ownerTeamId) {
        this.ownerTeamId = ownerTeamId;
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

}
