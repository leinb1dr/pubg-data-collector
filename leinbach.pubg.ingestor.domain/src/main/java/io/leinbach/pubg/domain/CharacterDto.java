package io.leinbach.pubg.domain;

import java.util.List;
import java.util.StringJoiner;

/**
 * @author leinb
 * @since 1/9/2019
 */
public class CharacterDto {
    private String name;
    private int teamId;
    private double health;
    private LocationDto location;
    private int rank;
    private String accountId;
    private String gameResult;
    private StatsDto stats;
    private boolean inBlueZone;
    private boolean inRedZone;
    private boolean attackerInVehicle;
    private List<String> zone;

    public boolean isAttackerInVehicle() {
        return attackerInVehicle;
    }

    public CharacterDto attackerInVehicle(boolean attackerInVehicle) {
        this.attackerInVehicle = attackerInVehicle;
        return this;
    }

    public String getGameResult() {
        return gameResult;
    }

    public CharacterDto gameResult(String gameResult) {
        this.gameResult = gameResult;
        return this;
    }

    public StatsDto getStats() {
        return stats;
    }

    public CharacterDto stats(StatsDto stats) {
        this.stats = stats;
        return this;
    }

    public String getName() {
        return name;
    }

    public CharacterDto name(String name) {
        this.name = name;
        return this;
    }

    public int getTeamId() {
        return teamId;
    }

    public CharacterDto teamId(int teamId) {
        this.teamId = teamId;
        return this;
    }

    public double getHealth() {
        return health;
    }

    public CharacterDto health(double health) {
        this.health = health;
        return this;
    }

    public LocationDto getLocation() {
        return location;
    }

    public CharacterDto location(LocationDto location) {
        this.location = location;
        return this;
    }

    public int getRank() {
        return rank;
    }

    public CharacterDto rank(int ranking) {
        this.rank = ranking;
        return this;
    }

    public String getAccountId() {
        return accountId;
    }

    public CharacterDto accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public boolean isInBlueZone() {
        return inBlueZone;
    }

    public CharacterDto inBlueZone(boolean inBlueZone) {
        this.inBlueZone = inBlueZone;
        return this;
    }

    public boolean isInRedZone() {
        return inRedZone;
    }

    public CharacterDto inRedZone(boolean inRedZone) {
        this.inRedZone = inRedZone;
        return this;
    }

    public List<String> getZone() {
        return zone;
    }

    public CharacterDto zone(List<String> zone) {
        this.zone = zone;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CharacterDto.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("teamId=" + teamId)
                .add("health=" + health)
                .add("location=" + location)
                .add("rank=" + rank)
                .add("accountId='" + accountId + "'")
                .add("gameResult='" + gameResult + "'")
                .add("stats=" + stats)
                .add("inBlueZone=" + inBlueZone)
                .add("inRedZone=" + inRedZone)
                .add("attackerInVehicle=" + attackerInVehicle)
                .add("zone=" + zone)
                .toString();
    }
}
