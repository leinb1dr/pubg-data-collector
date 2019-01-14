package io.leinbach.pubg.data.entity;

import io.leinbach.pubg.domain.ParticipantsDto;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import java.util.Map;

/**
 * @author leinb
 * @since 1/13/2019
 */
public class PlayerMatch {

    @PrimaryKey
    private final PlayerMatchId id;
    private final String playerName;
    private final int teamId;
    private final int rank;
    private final Map<String, Double> stats;

    public PlayerMatch(PlayerMatchId id, String playerName, int teamId, int rank, Map<String, Double> stats) {
        this.id = id;
        this.playerName = playerName;
        this.teamId = teamId;
        this.rank = rank;
        this.stats = stats;
    }

    public static PlayerMatch from(ParticipantsDto participantsDto) {
        return new PlayerMatch(new PlayerMatchId(participantsDto.getAccountId(),
                participantsDto.getMatchId()),
                participantsDto.getPlayerName(),
                participantsDto.getTeamId(),
                participantsDto.getRank(),
                participantsDto.getStats());
    }

    public PlayerMatchId getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getTeamId() {
        return teamId;
    }

    public int getRank() {
        return rank;
    }

    public Map<String, Double> getStats() {
        return stats;
    }

    public ParticipantsDto to() {
        return new ParticipantsDto()
                .playerName(playerName)
                .stats(stats)
                .matchId(id.getMatchId())
                .rank(rank)
                .teamId(teamId)
                .accountId(id.getAccountId());
    }
}
