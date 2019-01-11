package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.leinbach.pubg.domain.EventDto;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class LogGameStatePeriodic extends TelemetryBase {
    @JsonProperty("gameState")
    private GameState gameState;

    @Override
    public EventDto to() {
        return super.to().gameState(gameState.to());
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
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
