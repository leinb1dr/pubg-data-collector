package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogGameStatePeriodic extends TelemetryBase {
    @JsonProperty("gameState")
    private final GameState gameState;

    public LogGameStatePeriodic(LocalDateTime eventTimestamp, EventType eventType, TelemetryCommon common, GameState gameState) {
        super(eventTimestamp, eventType, common);
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogGameStatePeriodic that = (LogGameStatePeriodic) o;
        return Objects.equals(gameState, that.gameState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameState);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LogGameStatePeriodic.class.getSimpleName() + "[", "]")
                .add("gameState=" + gameState)
                .add("eventTimestamp=" + eventTimestamp)
                .add("eventType=" + eventType)
                .add("common=" + common)
                .toString();
    }
}
