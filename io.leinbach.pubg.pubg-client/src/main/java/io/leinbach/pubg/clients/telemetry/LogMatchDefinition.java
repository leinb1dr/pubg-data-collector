package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogMatchDefinition extends TelemetryBase {
    @JsonProperty("MatchId")
    private final String matchId;
    @JsonProperty("PingQuality")
    private final String pingQuality;
    @JsonProperty("SeasonState")
    private final String seasonState;

    public LogMatchDefinition(LocalDateTime eventTimestamp, EventType eventType, TelemetryCommon common, String matchId, String pingQuality, String seasonState) {
        super(eventTimestamp, eventType, common);
        this.matchId = matchId;
        this.pingQuality = pingQuality;
        this.seasonState = seasonState;
    }

    public String getMatchId() {
        return matchId;
    }

    public String getPingQuality() {
        return pingQuality;
    }

    public String getSeasonState() {
        return seasonState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogMatchDefinition that = (LogMatchDefinition) o;
        return Objects.equals(matchId, that.matchId) &&
                Objects.equals(pingQuality, that.pingQuality) &&
                Objects.equals(seasonState, that.seasonState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchId, pingQuality, seasonState);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LogMatchDefinition.class.getSimpleName() + "[", "]")
                .add("matchId='" + matchId + "'")
                .add("pingQuality='" + pingQuality + "'")
                .add("seasonState='" + seasonState + "'")
                .add("eventTimestamp=" + eventTimestamp)
                .add("eventType=" + eventType)
                .add("common=" + common)
                .toString();
    }
}
