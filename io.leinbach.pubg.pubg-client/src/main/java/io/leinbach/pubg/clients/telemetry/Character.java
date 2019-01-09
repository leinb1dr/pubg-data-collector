package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Character {
    @JsonProperty("name")
    private final String name;
    @JsonProperty("teamId")
    private final int teamId;
    @JsonProperty("health")
    private final double health;
    @JsonProperty("location")
    private final Location location;
    @JsonProperty("ranking")
    private final int ranking;
    @JsonProperty("accountId")
    private final String accountId;
    @JsonProperty("isInBlueZone")
    private final boolean inBlueZone;
    @JsonProperty("isInRedZone")
    private final boolean inRedZone;
    @JsonProperty("zone")
    private final List<String> zone;

    public Character(String name, int teamId, double health, Location location, int ranking, String accountId, boolean inBlueZone, boolean inRedZone, List<String> zone) {
        this.name = name;
        this.teamId = teamId;
        this.health = health;
        this.location = location;
        this.ranking = ranking;
        this.accountId = accountId;
        this.inBlueZone = inBlueZone;
        this.inRedZone = inRedZone;
        this.zone = zone;
    }

    public String getName() {
        return name;
    }

    public int getTeamId() {
        return teamId;
    }

    public double getHealth() {
        return health;
    }

    public Location getLocation() {
        return location;
    }

    public int getRanking() {
        return ranking;
    }

    public String getAccountId() {
        return accountId;
    }

    public boolean isInBlueZone() {
        return inBlueZone;
    }

    public boolean isInRedZone() {
        return inRedZone;
    }

    public List<String> getZone() {
        return zone;
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
