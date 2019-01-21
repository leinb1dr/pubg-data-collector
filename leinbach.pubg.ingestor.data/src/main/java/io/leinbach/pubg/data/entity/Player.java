package io.leinbach.pubg.data.entity;

import io.leinbach.pubg.domain.PlayerDto;
import io.leinbach.pubg.domain.SeasonStatsDto;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author leinb
 * @since 12/26/2018
 */
@Table
public class Player {
    @PrimaryKey
    private final String playername;

    private final String accountId;

    private final LocalDateTime lastUpdated;

    private final Map<String, Map<String, Object>> seasonStats;

    public Player(String playername, String accountId, LocalDateTime lastUpdated, Map<String, Map<String, Object>> seasonStats) {
        this.playername = playername;
        this.accountId = accountId;
        this.lastUpdated = lastUpdated;
        this.seasonStats = seasonStats;
    }

    public static Player from(PlayerDto player) {
        var seasonStats = player.getSeasonStats();
        var stats = new HashMap<String, Map<String, Object>>();
        if(seasonStats != null) {
            stats.put("duo", seasonStats.getDuo());
            stats.put("duoFpp", seasonStats.getDuoFpp());
            stats.put("solo", seasonStats.getSolo());
            stats.put("soloFpp", seasonStats.getSoloFpp());
            stats.put("squad", seasonStats.getSquad());
            stats.put("squadFpp", seasonStats.getSquadFpp());
        }


        return new Player(player.getName(), player.getId(), player.getLastUpdate() == null ? LocalDateTime.now()
                .minusHours(1): player.getLastUpdate(), stats);
    }

    public PlayerDto to() {
        var seasonStatsDto = new SeasonStatsDto();
        if(seasonStats != null) {
            seasonStatsDto
                    .duo(seasonStats.get("duo"))
                    .duoFpp(seasonStats.get("duoFpp"))
                    .solo(seasonStats.get("solo"))
                    .soloFpp(seasonStats.get("soloFpp"))
                    .squad(seasonStats.get("squad"))
                    .squadFpp(seasonStats.get("squadFpp"));
        }
        return new PlayerDto()
                .id(accountId)
                .name(playername)
                .lastUpdate(lastUpdated)
                .seasonStats(seasonStatsDto);
    }

    public Map<String, Map<String, Object>> getSeasonStats() {
        return seasonStats;
    }

    public String getPlayername() {
        return playername;
    }

    public String getAccountId() {
        return accountId;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }
}
