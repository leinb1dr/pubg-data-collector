package io.leinbach.pubg.clients.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author leinb
 * @since 1/8/2019
 */
public class RosterStats extends Stats {
    @JsonProperty("rank")
    private int rank;
    @JsonProperty("teamId")
    private int teamId;


    public int getRank() {
        return rank;
    }

    public RosterStats rank(int rank) {
        this.rank = rank;
        return this;
    }

    public int getTeamId() {
        return teamId;
    }

    public RosterStats teamId(int teamId) {
        this.teamId = teamId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RosterStats that = (RosterStats) o;
        return rank == that.rank &&
                teamId == that.teamId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, teamId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RosterStats.class.getSimpleName() + "[", "]")
                .add("rank=" + rank)
                .add("teamId=" + teamId)
                .toString();
    }
}
