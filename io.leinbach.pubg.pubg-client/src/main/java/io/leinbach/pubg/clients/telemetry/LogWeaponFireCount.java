package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogWeaponFireCount extends LogPlayerOnlyEvent {
    @JsonProperty("weaponId")
    private final String weaponId;
    @JsonProperty("fireCount")
    private final int fireCount;

    public LogWeaponFireCount(LocalDateTime eventTimestamp, EventType eventType, TelemetryCommon common, Character character, String weaponId, int fireCount) {
        super(eventTimestamp, eventType, common, character);
        this.weaponId = weaponId;
        this.fireCount = fireCount;
    }

    public String getWeaponId() {
        return weaponId;
    }

    public int getFireCount() {
        return fireCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LogWeaponFireCount that = (LogWeaponFireCount) o;
        return fireCount == that.fireCount &&
                Objects.equals(weaponId, that.weaponId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weaponId, fireCount);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LogWeaponFireCount.class.getSimpleName() + "[", "]")
                .add("weaponId='" + weaponId + "'")
                .add("fireCount=" + fireCount)
                .add("character=" + character)
                .add("eventTimestamp=" + eventTimestamp)
                .add("eventType=" + eventType)
                .add("common=" + common)
                .toString();
    }
}
