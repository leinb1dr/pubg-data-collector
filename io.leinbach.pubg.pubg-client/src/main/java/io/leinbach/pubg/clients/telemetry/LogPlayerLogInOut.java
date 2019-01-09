package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogPlayerLogInOut extends TelemetryBase {
    @JsonProperty("accountId")
    private String accountId;

    public LogPlayerLogInOut(LocalDateTime eventTimestamp, EventType eventType, TelemetryCommon common) {
        super(eventTimestamp, eventType, common);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LogPlayerLogInOut that = (LogPlayerLogInOut) o;
        return Objects.equals(accountId, that.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), accountId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LogPlayerLogInOut.class.getSimpleName() + "[", "]")
                .add("accountId='" + accountId + "'")
                .add("eventTimestamp=" + eventTimestamp)
                .add("eventType=" + eventType)
                .add("common=" + common)
                .toString();
    }

    public String getAccountId() {
        return accountId;
    }

    public LogPlayerLogInOut setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

}
