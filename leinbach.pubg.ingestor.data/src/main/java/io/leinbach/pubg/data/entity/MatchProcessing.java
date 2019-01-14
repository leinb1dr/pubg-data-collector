package io.leinbach.pubg.data.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Objects;

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

    public MatchProcessing(String matchId, Integer matchProcessing, Integer heatMapProcessing, LocalDateTime lastUpdated) {
        this.matchId = matchId;
        this.matchProcessing = Objects.requireNonNullElse(matchProcessing,0);
        this.heatMapProcessing = Objects.requireNonNullElse(heatMapProcessing, 0);
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
