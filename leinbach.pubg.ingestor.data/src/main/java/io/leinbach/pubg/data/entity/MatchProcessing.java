package io.leinbach.pubg.data.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * @author leinb
 * @since 1/11/2019
 */
@Table("matchProcessing")
public class MatchProcessing {
    @PrimaryKey
    private final String matchId;
    private final int matchProcessing;
    private final int heatMapProcessing;
    private final LocalDateTime lastUpdated;

    public MatchProcessing(String matchId, int matchProcessing, int heatMapProcessing, LocalDateTime lastUpdated) {
        this.matchId = matchId;
        this.matchProcessing = matchProcessing;
        this.heatMapProcessing = heatMapProcessing;
        this.lastUpdated = lastUpdated;
    }

    public String getMatchId() {
        return matchId;
    }

    public int getMatchProcessing() {
        return matchProcessing;
    }

    public int getHeatMapProcessing() {
        return heatMapProcessing;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public boolean needsProcessing() {
        return (matchProcessing == 0 || heatMapProcessing == 0);
    }
}
