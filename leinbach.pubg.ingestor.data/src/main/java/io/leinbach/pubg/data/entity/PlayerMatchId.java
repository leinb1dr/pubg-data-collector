package io.leinbach.pubg.data.entity;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

/**
 * @author leinb
 * @since 1/13/2019
 */
@PrimaryKeyClass
public class PlayerMatchId {
    @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private final String accountId;
    @PrimaryKeyColumn(ordinal = 2, type = PrimaryKeyType.CLUSTERED)
    private final String matchId;

    public PlayerMatchId(String accountId, String matchId) {
        this.accountId = accountId;
        this.matchId = matchId;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getMatchId() {
        return matchId;
    }
}
