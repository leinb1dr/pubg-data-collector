package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogObjectDestroy extends LogPlayerOnlyEvent {
    @JsonProperty("objectType")
    private String objectType;
    @JsonProperty("objectLocation")
    private Location objectLocation;

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public Location getObjectLocation() {
        return objectLocation;
    }

    public void setObjectLocation(Location objectLocation) {
        this.objectLocation = objectLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogObjectDestroy that = (LogObjectDestroy) o;
        return Objects.equals(character, that.character) &&
                Objects.equals(objectType, that.objectType) &&
                Objects.equals(objectLocation, that.objectLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(character, objectType, objectLocation);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LogObjectDestroy.class.getSimpleName() + "[", "]")
                .add("character=" + character)
                .add("objectType='" + objectType + "'")
                .add("objectLocation=" + objectLocation)
                .add("eventTimestamp=" + eventTimestamp)
                .add("eventType=" + eventType)
                .add("common=" + common)
                .toString();
    }
}
