package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.leinbach.pubg.domain.GameStateDto;

import java.util.Objects;
import java.util.StringJoiner;

public class GameState {
    @JsonProperty("elapsedTime")
    private int elapsedTime;
    @JsonProperty("numAliveTeams")
    private int numAliveTeams;
    @JsonProperty("numJoinPlayers")
    private int numJoinPlayers;
    @JsonProperty("numStartPlayers")
    private int numStartPlayers;
    @JsonProperty("numAlivePlayers")
    private int numAlivePlayers;
    @JsonProperty("safetyZonePosition")
    private Location safetyZonePosition;
    @JsonProperty("safetyZoneRadius")
    private double safetyZoneRadius;
    @JsonProperty("poisonGasWarningPosition")
    private Location poisonGasWarningPosition;
    @JsonProperty("poisonGasWarningRadius")
    private double poisonGasWarningRadius;
    @JsonProperty("redZonePosition")
    private Location redZonePosition;
    @JsonProperty("redZoneRadius")
    private double redZoneRadius;

    public int getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public int getNumAliveTeams() {
        return numAliveTeams;
    }

    public void setNumAliveTeams(int numAliveTeams) {
        this.numAliveTeams = numAliveTeams;
    }

    public int getNumJoinPlayers() {
        return numJoinPlayers;
    }

    public void setNumJoinPlayers(int numJoinPlayers) {
        this.numJoinPlayers = numJoinPlayers;
    }

    public int getNumStartPlayers() {
        return numStartPlayers;
    }

    public void setNumStartPlayers(int numStartPlayers) {
        this.numStartPlayers = numStartPlayers;
    }

    public int getNumAlivePlayers() {
        return numAlivePlayers;
    }

    public void setNumAlivePlayers(int numAlivePlayers) {
        this.numAlivePlayers = numAlivePlayers;
    }

    public Location getSafetyZonePosition() {
        return safetyZonePosition;
    }

    public void setSafetyZonePosition(Location safetyZonePosition) {
        this.safetyZonePosition = safetyZonePosition;
    }

    public double getSafetyZoneRadius() {
        return safetyZoneRadius;
    }

    public void setSafetyZoneRadius(double safetyZoneRadius) {
        this.safetyZoneRadius = safetyZoneRadius;
    }

    public Location getPoisonGasWarningPosition() {
        return poisonGasWarningPosition;
    }

    public void setPoisonGasWarningPosition(Location poisonGasWarningPosition) {
        this.poisonGasWarningPosition = poisonGasWarningPosition;
    }

    public double getPoisonGasWarningRadius() {
        return poisonGasWarningRadius;
    }

    public void setPoisonGasWarningRadius(double poisonGasWarningRadius) {
        this.poisonGasWarningRadius = poisonGasWarningRadius;
    }

    public Location getRedZonePosition() {
        return redZonePosition;
    }

    public void setRedZonePosition(Location redZonePosition) {
        this.redZonePosition = redZonePosition;
    }

    public double getRedZoneRadius() {
        return redZoneRadius;
    }

    public void setRedZoneRadius(double redZoneRadius) {
        this.redZoneRadius = redZoneRadius;
    }

    public GameStateDto to() {
        return new GameStateDto()
                .elapsedTime(elapsedTime)
                .numAlivePlayers(numAlivePlayers)
                .numAliveTeams(numAliveTeams)
                .numJoinPlayers(numJoinPlayers)
                .numStartPlayers(numStartPlayers)
                .poisonGasWarningPosition(poisonGasWarningPosition.to())
                .poisonGasWarningRadius(poisonGasWarningRadius)
                .redZonePosition(redZonePosition.to())
                .redZoneRadius(redZoneRadius)
                .safetyZonePosition(safetyZonePosition.to())
                .safetyZoneRadius(safetyZoneRadius);
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
