package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class LogPlayerRevive extends TelemetryBase {
    @JsonProperty("reviver")
    protected final Character reviver;
    @JsonProperty("victim")
    protected final Character victim;
    @JsonProperty("dBNOId")
    protected final int dbnoId;

    public LogPlayerRevive(LocalDateTime eventTimestamp, EventType eventType, TelemetryCommon common, Character reviver, Character victim, int dbnoId) {
        super(eventTimestamp, eventType, common);
        this.reviver = reviver;
        this.victim = victim;
        this.dbnoId = dbnoId;
    }

    public Character getReviver() {
        return reviver;
    }

    public Character getVictim() {
        return victim;
    }

    public int getDbnoId() {
        return dbnoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LogPlayerRevive that = (LogPlayerRevive) o;
        return dbnoId == that.dbnoId &&
                Objects.equals(reviver, that.reviver) &&
                Objects.equals(victim, that.victim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), reviver, victim, dbnoId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LogPlayerRevive.class.getSimpleName() + "[", "]")
                .add("reviver=" + reviver)
                .add("victim=" + victim)
                .add("dbnoId=" + dbnoId)
                .add("eventTimestamp=" + eventTimestamp)
                .add("eventType=" + eventType)
                .add("common=" + common)
                .toString();
    }
}
