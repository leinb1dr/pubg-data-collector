package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class TelemetryCommon {
    @JsonProperty("isGame")
    private boolean game;

    public TelemetryCommon() {
    }

    public TelemetryCommon(boolean game) {
        this.game = game;
    }

    public boolean isGame() {
        return game;
    }

    public TelemetryCommon setGame(boolean game) {
        this.game = game;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelemetryCommon that = (TelemetryCommon) o;
        return game == that.game;
    }

    @Override
    public int hashCode() {
        return Objects.hash(game);
    }

    @Override
    public String toString() {
        return "TelemetryCommon{" +
                "game=" + game +
                '}';
    }
}
