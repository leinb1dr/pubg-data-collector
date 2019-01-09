package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.StringJoiner;

public class GameState {
    @JsonProperty("elapsedTime")
    private final int elapsedTime;
    @JsonProperty("numAliveTeams")
    private final int numAliveTeams;
    @JsonProperty("numJoinPlayers")
    private final int numJoinPlayers;
    @JsonProperty("numStartPlayers")
    private final int numStartPlayers;
    @JsonProperty("numAlivePlayers")
    private final int numAlivePlayers;
    @JsonProperty("safetyZonePosition")
    private final Location safetyZonePosition;
    @JsonProperty("safetyZoneRadius")
    private final double safetyZoneRadius;
    @JsonProperty("poisonGasWarningPosition")
    private final Location poisonGasWarningPosition;
    @JsonProperty("poisonGasWarningRadius")
    private final double poisonGasWarningRadius;
    @JsonProperty("redZonePosition")
    private final Location redZonePosition;
    @JsonProperty("redZoneRadius")
    private final double redZoneRadius;

    public GameState(int elapsedTime, int numAliveTeams, int numJoinPlayers, int numStartPlayers, int numAlivePlayers, Location safetyZonePosition, double safetyZoneRadius, Location poisonGasWarningPosition, double poisonGasWarningRadius, Location redZonePosition, double redZoneRadius) {
        this.elapsedTime = elapsedTime;
        this.numAliveTeams = numAliveTeams;
        this.numJoinPlayers = numJoinPlayers;
        this.numStartPlayers = numStartPlayers;
        this.numAlivePlayers = numAlivePlayers;
        this.safetyZonePosition = safetyZonePosition;
        this.safetyZoneRadius = safetyZoneRadius;
        this.poisonGasWarningPosition = poisonGasWarningPosition;
        this.poisonGasWarningRadius = poisonGasWarningRadius;
        this.redZonePosition = redZonePosition;
        this.redZoneRadius = redZoneRadius;
    }

    public int getElapsedTime() {
        return elapsedTime;
    }

    public int getNumAliveTeams() {
        return numAliveTeams;
    }

    public int getNumJoinPlayers() {
        return numJoinPlayers;
    }

    public int getNumStartPlayers() {
        return numStartPlayers;
    }

    public int getNumAlivePlayers() {
        return numAlivePlayers;
    }

    public Location getSafetyZonePosition() {
        return safetyZonePosition;
    }

    public double getSafetyZoneRadius() {
        return safetyZoneRadius;
    }

    public Location getPoisonGasWarningPosition() {
        return poisonGasWarningPosition;
    }

    public double getPoisonGasWarningRadius() {
        return poisonGasWarningRadius;
    }

    public Location getRedZonePosition() {
        return redZonePosition;
    }

    public double getRedZoneRadius() {
        return redZoneRadius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameState gameState = (GameState) o;
        return elapsedTime == gameState.elapsedTime &&
                numAliveTeams == gameState.numAliveTeams &&
                numJoinPlayers == gameState.numJoinPlayers &&
                numStartPlayers == gameState.numStartPlayers &&
                numAlivePlayers == gameState.numAlivePlayers &&
                Double.compare(gameState.safetyZoneRadius, safetyZoneRadius) == 0 &&
                Double.compare(gameState.poisonGasWarningRadius, poisonGasWarningRadius) == 0 &&
                Double.compare(gameState.redZoneRadius, redZoneRadius) == 0 &&
                Objects.equals(safetyZonePosition, gameState.safetyZonePosition) &&
                Objects.equals(poisonGasWarningPosition, gameState.poisonGasWarningPosition) &&
                Objects.equals(redZonePosition, gameState.redZonePosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elapsedTime, numAliveTeams, numJoinPlayers, numStartPlayers, numAlivePlayers, safetyZonePosition, safetyZoneRadius, poisonGasWarningPosition, poisonGasWarningRadius, redZonePosition, redZoneRadius);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GameState.class.getSimpleName() + "[", "]")
                .add("elapsedTime=" + elapsedTime)
                .add("numAliveTeams=" + numAliveTeams)
                .add("numJoinPlayers=" + numJoinPlayers)
                .add("numStartPlayers=" + numStartPlayers)
                .add("numAlivePlayers=" + numAlivePlayers)
                .add("safetyZonePosition=" + safetyZonePosition)
                .add("safetyZoneRadius=" + safetyZoneRadius)
                .add("poisonGasWarningPosition=" + poisonGasWarningPosition)
                .add("poisonGasWarningRadius=" + poisonGasWarningRadius)
                .add("redZonePosition=" + redZonePosition)
                .add("redZoneRadius=" + redZoneRadius)
                .toString();
    }
}
