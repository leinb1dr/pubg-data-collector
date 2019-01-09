package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.StringJoiner;

public class GameResult {
    @JsonProperty("rank")
    private final int rank;
    @JsonProperty("gameResult")
    private final String gameResult;
    @JsonProperty("teamId")
    private final int teamId;
    @JsonProperty("stats")
    private final Stats stats;
    @JsonProperty("accountId")
    private final String accountId;

    public GameResult(int rank, String gameResult, int teamId, Stats stats, String accountId) {
        this.rank = rank;
        this.gameResult = gameResult;
        this.teamId = teamId;
        this.stats = stats;
        this.accountId = accountId;
    }

    public int getRank() {
        return rank;
    }

    public String getGameResult() {
        return gameResult;
    }

    public int getTeamId() {
        return teamId;
    }

    public Stats getStats() {
        return stats;
    }

    public String getAccountId() {
        return accountId;
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
