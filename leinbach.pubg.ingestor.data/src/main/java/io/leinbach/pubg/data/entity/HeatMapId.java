package io.leinbach.pubg.data.entity;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.time.LocalDateTime;

/**
 * @author leinb
 * @since 1/14/2019
 */
@PrimaryKeyClass
public class HeatMapId {
    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String matchId;
    @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String character_accountId;
    @PrimaryKeyColumn(ordinal = 2, type = PrimaryKeyType.PARTITIONED)
    private String damageReason;
    @PrimaryKeyColumn(ordinal = 3, type = PrimaryKeyType.CLUSTERED)
    private LocalDateTime eventTimestamp;

    public String getMatchId() {
        return matchId;
    }

    public HeatMapId matchId(String matchId) {
        this.matchId = matchId;
        return this;
    }

    public String getCharacter_accountId() {
        return character_accountId;
    }

    public HeatMapId character_accountId(String character_accountId) {
        this.character_accountId = character_accountId;
        return this;
    }

    public String getDamageReason() {
        return damageReason;
    }

    public HeatMapId damageReason(String damageReason) {
        this.damageReason = damageReason;
        return this;
    }

    public LocalDateTime getEventTimestamp() {
        return eventTimestamp;
    }

    public HeatMapId eventTimestamp(LocalDateTime eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
        return this;
    }
}
