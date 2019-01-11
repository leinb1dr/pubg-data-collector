package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.leinbach.pubg.domain.CharacterDto;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Character {
    @JsonProperty("name")
    private String name;
    @JsonProperty("teamId")
    private int teamId;
    @JsonProperty("health")
    private double health;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("ranking")
    private int ranking;
    @JsonProperty("accountId")
    private String accountId;
    @JsonProperty("isInBlueZone")
    private boolean inBlueZone;
    @JsonProperty("isInRedZone")
    private boolean inRedZone;
    @JsonProperty("zone")
    private List<String> zone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public boolean isInBlueZone() {
        return inBlueZone;
    }

    public void setInBlueZone(boolean inBlueZone) {
        this.inBlueZone = inBlueZone;
    }

    public boolean isInRedZone() {
        return inRedZone;
    }

    public void setInRedZone(boolean inRedZone) {
        this.inRedZone = inRedZone;
    }

    public List<String> getZone() {
        return zone;
    }

    public void setZone(List<String> zone) {
        this.zone = zone;
    }

    public CharacterDto to() {
        return new CharacterDto().accountId(accountId)
                .health(health)
                .inBlueZone(inBlueZone)
                .inRedZone(inRedZone)
                .location(location.to())
                .name(name)
                .rank(ranking)
                .teamId(teamId)
                .zone(zone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return teamId == character.teamId &&
                Double.compare(character.health, health) == 0 &&
                ranking == character.ranking &&
                inBlueZone == character.inBlueZone &&
                inRedZone == character.inRedZone &&
                Objects.equals(name, character.name) &&
                Objects.equals(location, character.location) &&
                Objects.equals(accountId, character.accountId) &&
                Objects.equals(zone, character.zone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, teamId, health, location, ranking, accountId, inBlueZone, inRedZone, zone);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Character.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("teamId=" + teamId)
                .add("health=" + health)
                .add("location=" + location)
                .add("ranking=" + ranking)
                .add("accountId='" + accountId + "'")
                .add("inBlueZone=" + inBlueZone)
                .add("inRedZone=" + inRedZone)
                .add("zone=" + zone)
                .toString();
    }
}
