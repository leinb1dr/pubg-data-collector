package io.leinbach.pubg.data.entity;

import io.leinbach.pubg.domain.ParticipantsDto;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author leinb
 * @since 1/13/2019
 */
@Table
public class PlayerMatch {

    @PrimaryKey
    private final PlayerMatchId id;
    private final String playerName;
    private final LocalDateTime matchDateTime;
    private final Integer teamId;
    private final String map;
    private final Integer rank;
    private final Map<String, Object> stats;
    public PlayerMatch(PlayerMatchId id, LocalDateTime matchDateTime, String playerName, Integer teamId, String map, Integer rank, Map<String, Object> stats) {
        this.id = id;
        this.matchDateTime = matchDateTime;
        this.playerName = playerName;
        this.teamId = teamId;
        this.map = map;
        this.rank = rank;
        this.stats = stats;
    }

    public static PlayerMatch from(ParticipantsDto participantsDto) {
        return new PlayerMatch(
                new PlayerMatchId(participantsDto.getAccountId(),
                        participantsDto.getGameMode(),
                        participantsDto.getMatchId()),
                participantsDto.getMatchDateTime(),
                participantsDto.getPlayerName(),
                participantsDto.getTeamId(),
                participantsDto.getMap(), participantsDto.getRank(),
                participantsDto.getStats());
    }

    public String getMap() {
        return map;
    }

    public PlayerMatchId getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public Integer getRank() {
        return rank;
    }

    public Map<String, Object> getStats() {
        return stats;
    }

    public ParticipantsDto to() {
        return new ParticipantsDto()
                .playerName(playerName)
                .stats(stats)
                .gameMode(id.getGameMode())
                .matchDateTime(matchDateTime)
                .matchId(id.getMatchId())
                .rank(rank)
                .map(map)
                .teamId(teamId)
                .accountId(id.getAccountId());
    }

    public LocalDateTime getMatchDateTime() {
        return matchDateTime;
    }
}
