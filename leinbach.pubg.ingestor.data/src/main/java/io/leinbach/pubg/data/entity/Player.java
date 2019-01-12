package io.leinbach.pubg.data.entity;

import io.leinbach.pubg.domain.PlayerDto;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

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

    public Player(String username, String accountId, LocalDateTime lastUpdated) {
        this.playername = username;
        this.accountId = accountId;
        this.lastUpdated = lastUpdated;
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

    public static PlayerDto to(Player player) {
        return new PlayerDto()
                .id(player.accountId)
                .name(player.playername)
                .lastUpdate(player.lastUpdated);
    }
}
