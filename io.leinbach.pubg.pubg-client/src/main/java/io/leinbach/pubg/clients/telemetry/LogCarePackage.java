package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogCarePackage extends TelemetryBase{
    @JsonProperty("itemPackage")
    private final ItemPackage itemPackage;

    public LogCarePackage(LocalDateTime eventTimestamp, EventType eventType, TelemetryCommon common, ItemPackage itemPackage) {
        super(eventTimestamp, eventType, common);
        this.itemPackage = itemPackage;
    }

    public ItemPackage getItemPackage() {
        return itemPackage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogCarePackage that = (LogCarePackage) o;
        return Objects.equals(itemPackage, that.itemPackage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemPackage);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LogCarePackage.class.getSimpleName() + "[", "]")
                .add("itemPackage=" + itemPackage)
                .add("eventTimestamp=" + eventTimestamp)
                .add("eventType=" + eventType)
                .add("common=" + common)
                .toString();
    }
}
