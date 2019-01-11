package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.leinbach.pubg.domain.EventDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class LogPlayerRevive extends TelemetryBase {
    @JsonProperty("reviver")
    protected Character reviver;
    @JsonProperty("victim")
    protected Character victim;
    @JsonProperty("dBNOId")
    protected int dbnoId;

    @Override
    public EventDto to() {
        return new EventDto()
                .character(reviver.to())
                .target(victim.to())
                .dbnoId(dbnoId);
    }

    public Character getReviver() {
        return reviver;
    }

    public void setReviver(Character reviver) {
        this.reviver = reviver;
    }

    public Character getVictim() {
        return victim;
    }

    public void setVictim(Character victim) {
        this.victim = victim;
    }

    public int getDbnoId() {
        return dbnoId;
    }

    public void setDbnoId(int dbnoId) {
        this.dbnoId = dbnoId;
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
