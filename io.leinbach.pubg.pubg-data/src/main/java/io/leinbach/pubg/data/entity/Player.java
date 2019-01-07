package io.leinbach.pubg.data.entity;

import io.leinbach.pubg.domain.PlayerDto;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * @author leinb
 * @since 12/26/2018
 */
@Table
public class Player {
    @PrimaryKey
    private final String username;

    private final String pubgid;

    public Player(String username, String pubgid) {
        this.username = username;
        this.pubgid = pubgid;
    }

    public PlayerDto to() {
        return new PlayerDto().id(pubgid)
                .name(username);
    }


    public String name() {
        return username;
    }

    public String pubgId() {
        return pubgid;
    }
}
