package io.leinbach.pubg.domain;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author leinb
 * @since 1/13/2019
 */
public class ParticipantsDto {
    private String matchId;
    private LocalDateTime matchDateTime;
    private String gameMode;
    private String map;
    private String accountId;
    private String playerName;
    private int teamId;
    private int rank;
    private Map<String, Object> stats;

    public LocalDateTime getMatchDateTime() {
        return matchDateTime;
    }

    public ParticipantsDto matchDateTime(LocalDateTime matchDate) {
        this.matchDateTime = matchDate;
        return this;
    }

    public String getGameMode() {
        return gameMode;
    }

    public ParticipantsDto gameMode(String gameMode) {
        this.gameMode = gameMode;
        return this;
    }

    public String getMap() {
        return map;
    }

    public ParticipantsDto map(String map) {
        this.map = map;
        return this;
    }

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

    public Map<String, Object> getStats() {
        return stats;
    }

    public ParticipantsDto stats(Map<String, Object> stats) {
        this.stats = stats;
        return this;
    }
}
