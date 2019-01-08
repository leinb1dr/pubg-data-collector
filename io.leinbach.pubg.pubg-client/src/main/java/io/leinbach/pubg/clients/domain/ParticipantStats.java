package io.leinbach.pubg.clients.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author leinb
 * @since 1/7/2019
 */
public class ParticipantStats extends Stats {
    @JsonProperty("DBNOs")
    private int dBNOs;
    @JsonProperty("assists")
    private int assists;
    @JsonProperty("boosts")
    private int boosts;
    @JsonProperty("damageDealt")
    private double damageDealt;
    @JsonProperty("deathType")
    private String deathType;
    @JsonProperty("headshotKills")
    private int headshotKills;
    @JsonProperty("heals")
    private int heals;
    @JsonProperty("killPlace")
    private int killPlace;
    @JsonProperty("killPoints")
    private double killPoints;
    @JsonProperty("killPointsDelta")
    private double killPointsDelta;
    @JsonProperty("killSteaks")
    private int killStreak;
    @JsonProperty("kills")
    private int kills;
    @JsonProperty("lastKillPoints")
    private int lastKillPoints;
    @JsonProperty("lastWinPoints")
    private int lastWinPoint;
    @JsonProperty("longestKill")
    private double longestKill;
    @JsonProperty("mostDamage")
    private double mostDamange;
    @JsonProperty("name")
    private String name;
    @JsonProperty("playerId")
    private String playerId;
    @JsonProperty("rankPoints")
    private double rankPoints;
    @JsonProperty("revives")
    private int revives;
    @JsonProperty("rideDistance")
    private double rideDistance;
    @JsonProperty("roadKills")
    private int roadKills;
    @JsonProperty("swimDistance")
    private double swimDistance;
    @JsonProperty("teamKills")
    private int teamKills;
    @JsonProperty("timeSurvived")
    private double timeSurvived;
    @JsonProperty("vehicleDestroys")
    private int vehicleDestroys;
    @JsonProperty("walkDistance")
    private double walkDistance;
    @JsonProperty("weaponsAcquired")
    private int weaponsAcquired;
    @JsonProperty("winPlace")
    private int winPlace;
    @JsonProperty("winPoints")
    private double winPoints;
    @JsonProperty("winPointsDelta")
    private double winPointsDelta;


    public ParticipantStats() {
    }

    public ParticipantStats(int dBNOs, int assists, int boosts, double damageDealt, String deathType, int headshotKills, int heals, int killPlace, double killPoints, double killPointsDelta, int killStreak, int kills, int lastKillPoints, int lastWinPoint, double longestKill, double mostDamange, String name, String playerId, double rankPoints, int revives, double rideDistance, int roadKills, double swimDistance, int teamKills, double timeSurvived, int vehicleDestroys, double walkDistance, int weaponsAcquired, int winPlace, double winPoints, double winPointsDelta) {
        this.dBNOs = dBNOs;
        this.assists = assists;
        this.boosts = boosts;
        this.damageDealt = damageDealt;
        this.deathType = deathType;
        this.headshotKills = headshotKills;
        this.heals = heals;
        this.killPlace = killPlace;
        this.killPoints = killPoints;
        this.killPointsDelta = killPointsDelta;
        this.killStreak = killStreak;
        this.kills = kills;
        this.lastKillPoints = lastKillPoints;
        this.lastWinPoint = lastWinPoint;
        this.longestKill = longestKill;
        this.mostDamange = mostDamange;
        this.name = name;
        this.playerId = playerId;
        this.rankPoints = rankPoints;
        this.revives = revives;
        this.rideDistance = rideDistance;
        this.roadKills = roadKills;
        this.swimDistance = swimDistance;
        this.teamKills = teamKills;
        this.timeSurvived = timeSurvived;
        this.vehicleDestroys = vehicleDestroys;
        this.walkDistance = walkDistance;
        this.weaponsAcquired = weaponsAcquired;
        this.winPlace = winPlace;
        this.winPoints = winPoints;
        this.winPointsDelta = winPointsDelta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipantStats that = (ParticipantStats) o;
        return dBNOs == that.dBNOs &&
                assists == that.assists &&
                boosts == that.boosts &&
                Double.compare(that.damageDealt, damageDealt) == 0 &&
                headshotKills == that.headshotKills &&
                heals == that.heals &&
                killPlace == that.killPlace &&
                Double.compare(that.killPoints, killPoints) == 0 &&
                Double.compare(that.killPointsDelta, killPointsDelta) == 0 &&
                killStreak == that.killStreak &&
                kills == that.kills &&
                lastKillPoints == that.lastKillPoints &&
                lastWinPoint == that.lastWinPoint &&
                Double.compare(that.longestKill, longestKill) == 0 &&
                Double.compare(that.mostDamange, mostDamange) == 0 &&
                Double.compare(that.rankPoints, rankPoints) == 0 &&
                revives == that.revives &&
                Double.compare(that.rideDistance, rideDistance) == 0 &&
                roadKills == that.roadKills &&
                Double.compare(that.swimDistance, swimDistance) == 0 &&
                teamKills == that.teamKills &&
                Double.compare(that.timeSurvived, timeSurvived) == 0 &&
                vehicleDestroys == that.vehicleDestroys &&
                Double.compare(that.walkDistance, walkDistance) == 0 &&
                weaponsAcquired == that.weaponsAcquired &&
                winPlace == that.winPlace &&
                Double.compare(that.winPoints, winPoints) == 0 &&
                Double.compare(that.winPointsDelta, winPointsDelta) == 0 &&
                Objects.equals(deathType, that.deathType) &&
                Objects.equals(name, that.name) &&
                Objects.equals(playerId, that.playerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dBNOs, assists, boosts, damageDealt, deathType, headshotKills, heals, killPlace, killPoints, killPointsDelta, killStreak, kills, lastKillPoints, lastWinPoint, longestKill, mostDamange, name, playerId, rankPoints, revives, rideDistance, roadKills, swimDistance, teamKills, timeSurvived, vehicleDestroys, walkDistance, weaponsAcquired, winPlace, winPoints, winPointsDelta);
    }

    public int getdBNOs() {
        return dBNOs;
    }

    public ParticipantStats dBNOs(int dBNOs) {
        this.dBNOs = dBNOs;
        return this;
    }

    public int getAssists() {
        return assists;
    }

    public ParticipantStats assists(int assists) {
        this.assists = assists;
        return this;
    }

    public int getBoosts() {
        return boosts;
    }

    public ParticipantStats boosts(int boosts) {
        this.boosts = boosts;
        return this;
    }

    public double getDamageDealt() {
        return damageDealt;
    }

    public ParticipantStats damageDealt(double damageDealt) {
        this.damageDealt = damageDealt;
        return this;
    }

    public String getDeathType() {
        return deathType;
    }

    public ParticipantStats deathType(String deathType) {
        this.deathType = deathType;
        return this;
    }

    public int getHeadshotKills() {
        return headshotKills;
    }

    public ParticipantStats headshotKills(int headshotKills) {
        this.headshotKills = headshotKills;
        return this;
    }

    public int getHeals() {
        return heals;
    }

    public ParticipantStats heals(int heals) {
        this.heals = heals;
        return this;
    }

    public int getKillPlace() {
        return killPlace;
    }

    public ParticipantStats killPlace(int killPlace) {
        this.killPlace = killPlace;
        return this;
    }

    public double getKillPoints() {
        return killPoints;
    }

    public ParticipantStats killPoints(double killPoints) {
        this.killPoints = killPoints;
        return this;
    }

    public double getKillPointsDelta() {
        return killPointsDelta;
    }

    public ParticipantStats killPointsDelta(double killPointsDelta) {
        this.killPointsDelta = killPointsDelta;
        return this;
    }

    public int getKillStreak() {
        return killStreak;
    }

    public ParticipantStats killStreak(int killStreak) {
        this.killStreak = killStreak;
        return this;
    }

    public int getKills() {
        return kills;
    }

    public ParticipantStats kills(int kills) {
        this.kills = kills;
        return this;
    }

    public int getLastKillPoints() {
        return lastKillPoints;
    }

    public ParticipantStats lastKillPoints(int lastKillPoints) {
        this.lastKillPoints = lastKillPoints;
        return this;
    }

    public int getLastWinPoint() {
        return lastWinPoint;
    }

    public ParticipantStats lastWinPoint(int lastWinPoint) {
        this.lastWinPoint = lastWinPoint;
        return this;
    }

    public double getLongestKill() {
        return longestKill;
    }

    public ParticipantStats longestKill(double longestKill) {
        this.longestKill = longestKill;
        return this;
    }

    public double getMostDamange() {
        return mostDamange;
    }

    public ParticipantStats mostDamange(double mostDamange) {
        this.mostDamange = mostDamange;
        return this;
    }

    public String getName() {
        return name;
    }

    public ParticipantStats name(String name) {
        this.name = name;
        return this;
    }

    public String getPlayerId() {
        return playerId;
    }

    public ParticipantStats playerId(String playerId) {
        this.playerId = playerId;
        return this;
    }

    public double getRankPoints() {
        return rankPoints;
    }

    public ParticipantStats rankPoints(double rankPoints) {
        this.rankPoints = rankPoints;
        return this;
    }

    public int getRevives() {
        return revives;
    }

    public ParticipantStats revives(int revives) {
        this.revives = revives;
        return this;
    }

    public double getRideDistance() {
        return rideDistance;
    }

    public ParticipantStats rideDistance(double rideDistance) {
        this.rideDistance = rideDistance;
        return this;
    }

    public int getRoadKills() {
        return roadKills;
    }

    public ParticipantStats roadKills(int roadKills) {
        this.roadKills = roadKills;
        return this;
    }

    public double getSwimDistance() {
        return swimDistance;
    }

    public ParticipantStats swimDistance(double swimDistance) {
        this.swimDistance = swimDistance;
        return this;
    }

    public int getTeamKills() {
        return teamKills;
    }

    public ParticipantStats teamKills(int teamKills) {
        this.teamKills = teamKills;
        return this;
    }

    public double getTimeSurvived() {
        return timeSurvived;
    }

    public ParticipantStats timeSurvived(double timeSurvived) {
        this.timeSurvived = timeSurvived;
        return this;
    }

    public int getVehicleDestroys() {
        return vehicleDestroys;
    }

    public ParticipantStats vehicleDestroys(int vehicleDestroys) {
        this.vehicleDestroys = vehicleDestroys;
        return this;
    }

    public double getWalkDistance() {
        return walkDistance;
    }

    public ParticipantStats walkDistance(double walkDistance) {
        this.walkDistance = walkDistance;
        return this;
    }

    public int getWeaponsAcquired() {
        return weaponsAcquired;
    }

    public ParticipantStats weaponsAcquired(int weaponsAcquired) {
        this.weaponsAcquired = weaponsAcquired;
        return this;
    }

    public int getWinPlace() {
        return winPlace;
    }

    public ParticipantStats winPlace(int winPlace) {
        this.winPlace = winPlace;
        return this;
    }

    public double getWinPoints() {
        return winPoints;
    }

    public ParticipantStats winPoints(double winPoints) {
        this.winPoints = winPoints;
        return this;
    }

    public double getWinPointsDelta() {
        return winPointsDelta;
    }

    public ParticipantStats winPointsDelta(double winPointsDelta) {
        this.winPointsDelta = winPointsDelta;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ParticipantStats.class.getSimpleName() + "[", "]")
                .add("dBNOs=" + dBNOs)
                .add("assists=" + assists)
                .add("boosts=" + boosts)
                .add("damageDealt=" + damageDealt)
                .add("deathType='" + deathType + "'")
                .add("headshotKills=" + headshotKills)
                .add("heals=" + heals)
                .add("killPlace=" + killPlace)
                .add("killPoints=" + killPoints)
                .add("killPointsDelta=" + killPointsDelta)
                .add("killStreak=" + killStreak)
                .add("kills=" + kills)
                .add("lastKillPoints=" + lastKillPoints)
                .add("lastWinPoint=" + lastWinPoint)
                .add("longestKill=" + longestKill)
                .add("mostDamange=" + mostDamange)
                .add("name='" + name + "'")
                .add("playerId='" + playerId + "'")
                .add("rankPoints=" + rankPoints)
                .add("revives=" + revives)
                .add("rideDistance=" + rideDistance)
                .add("roadKills=" + roadKills)
                .add("swimDistance=" + swimDistance)
                .add("teamKills=" + teamKills)
                .add("timeSurvived=" + timeSurvived)
                .add("vehicleDestroys=" + vehicleDestroys)
                .add("walkDistance=" + walkDistance)
                .add("weaponsAcquired=" + weaponsAcquired)
                .add("winPlace=" + winPlace)
                .add("winPoints=" + winPoints)
                .add("winPointsDelta=" + winPointsDelta)
                .toString();
    }
}
