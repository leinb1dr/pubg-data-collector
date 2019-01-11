package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.leinbach.pubg.domain.EventDto;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogMatchDefinition extends TelemetryBase {
    @JsonProperty("MatchId")
    private String matchId;
    @JsonProperty("PingQuality")
    private String pingQuality;
    @JsonProperty("SeasonState")
    private String seasonState;

    @Override
    public EventDto to() {
        return new EventDto()
                .matchId(matchId)
                .pingQuality(pingQuality)
                .seasonState(seasonState);
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getPingQuality() {
        return pingQuality;
    }

    public void setPingQuality(String pingQuality) {
        this.pingQuality = pingQuality;
    }

    public String getSeasonState() {
        return seasonState;
    }

    public void setSeasonState(String seasonState) {
        this.seasonState = seasonState;
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
