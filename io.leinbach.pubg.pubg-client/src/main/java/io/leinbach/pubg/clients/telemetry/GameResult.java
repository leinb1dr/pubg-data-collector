package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.StringJoiner;

public class GameResult {
    @JsonProperty("rank")
    private int rank;
    @JsonProperty("gameResult")
    private String gameResult;
    @JsonProperty("teamId")
    private int teamId;
    @JsonProperty("stats")
    private Stats stats;
    @JsonProperty("accountId")
    private String accountId;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getGameResult() {
        return gameResult;
    }

    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return rank == that.rank &&
                teamId == that.teamId &&
                Objects.equals(gameResult, that.gameResult) &&
                Objects.equals(stats, that.stats) &&
                Objects.equals(accountId, that.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, gameResult, teamId, stats, accountId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GameResult.class.getSimpleName() + "[", "]")
                .add("rank=" + rank)
                .add("gameResult='" + gameResult + "'")
                .add("teamId=" + teamId)
                .add("stats=" + stats)
                .add("accountId='" + accountId + "'")
                .toString();
    }
}
