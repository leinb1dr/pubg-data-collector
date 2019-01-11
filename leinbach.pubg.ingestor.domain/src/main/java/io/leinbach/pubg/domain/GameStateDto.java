package io.leinbach.pubg.domain;

import java.util.StringJoiner;

/**
 * @author leinb
 * @since 1/9/2019
 */
public class GameStateDto {

    private int elapsedTime;
    private int numAliveTeams;
    private int numJoinPlayers;
    private int numStartPlayers;
    private int numAlivePlayers;
    private LocationDto safetyZonePosition;
    private double safetyZoneRadius;
    private LocationDto poisonGasWarningPosition;
    private double poisonGasWarningRadius;
    private LocationDto redZonePosition;
    private double redZoneRadius;

    public int getElapsedTime() {
        return elapsedTime;
    }

    public GameStateDto elapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
        return this;
    }

    public int getNumAliveTeams() {
        return numAliveTeams;
    }

    public GameStateDto numAliveTeams(int numAliveTeams) {
        this.numAliveTeams = numAliveTeams;
        return this;
    }

    public int getNumJoinPlayers() {
        return numJoinPlayers;
    }

    public GameStateDto numJoinPlayers(int numJoinPlayers) {
        this.numJoinPlayers = numJoinPlayers;
        return this;
    }

    public int getNumStartPlayers() {
        return numStartPlayers;
    }

    public GameStateDto numStartPlayers(int numStartPlayers) {
        this.numStartPlayers = numStartPlayers;
        return this;
    }

    public int getNumAlivePlayers() {
        return numAlivePlayers;
    }

    public GameStateDto numAlivePlayers(int numAlivePlayers) {
        this.numAlivePlayers = numAlivePlayers;
        return this;
    }

    public LocationDto getSafetyZonePosition() {
        return safetyZonePosition;
    }

    public GameStateDto safetyZonePosition(LocationDto safetyZonePosition) {
        this.safetyZonePosition = safetyZonePosition;
        return this;
    }

    public double getSafetyZoneRadius() {
        return safetyZoneRadius;
    }

    public GameStateDto safetyZoneRadius(double safetyZoneRadius) {
        this.safetyZoneRadius = safetyZoneRadius;
        return this;
    }

    public LocationDto getPoisonGasWarningPosition() {
        return poisonGasWarningPosition;
    }

    public GameStateDto poisonGasWarningPosition(LocationDto poisonGasWarningPosition) {
        this.poisonGasWarningPosition = poisonGasWarningPosition;
        return this;
    }

    public double getPoisonGasWarningRadius() {
        return poisonGasWarningRadius;
    }

    public GameStateDto poisonGasWarningRadius(double poisonGasWarningRadius) {
        this.poisonGasWarningRadius = poisonGasWarningRadius;
        return this;
    }

    public LocationDto getRedZonePosition() {
        return redZonePosition;
    }

    public GameStateDto redZonePosition(LocationDto redZonePosition) {
        this.redZonePosition = redZonePosition;
        return this;
    }

    public double getRedZoneRadius() {
        return redZoneRadius;
    }

    public GameStateDto redZoneRadius(double redZoneRadius) {
        this.redZoneRadius = redZoneRadius;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GameStateDto.class.getSimpleName() + "[", "]")
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
