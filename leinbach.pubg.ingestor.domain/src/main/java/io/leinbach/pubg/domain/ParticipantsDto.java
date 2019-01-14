package io.leinbach.pubg.domain;

import java.util.Map;

/**
 * @author leinb
 * @since 1/13/2019
 */
public class ParticipantsDto {
    private String matchId;
    private String accountId;
    private String playerName;
    private int teamId;
    private int rank;
    private Map<String, Double> stats;

    public String getPlayerName() {
        return playerName;
    }

    public ParticipantsDto playerName(String playerName) {
        this.playerName = playerName;
        return this;
    }

    public String getMatchId() {
        return matchId;
    }

    public ParticipantsDto matchId(String matchId) {
        this.matchId = matchId;
        return this;
    }

    public String getAccountId() {
        return accountId;
    }

    public ParticipantsDto accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public int getTeamId() {
        return teamId;
    }

    public ParticipantsDto teamId(int teamId) {
        this.teamId = teamId;
        return this;
    }

    public int getRank() {
        return rank;
    }

    public ParticipantsDto rank(int rank) {
        this.rank = rank;
        return this;
    }

    public Map<String, Double> getStats() {
        return stats;
    }

    public ParticipantsDto stats(Map<String, Double> stats) {
        this.stats = stats;
        return this;
    }
}
