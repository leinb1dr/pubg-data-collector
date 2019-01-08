package io.leinbach.pubg.clients.domain;

import java.time.LocalDateTime;

/**
 * @author leinb
 * @since 1/8/2019
 */
public class RosterAttributes extends Attributes<RosterStats> {
    private String won;

    @Override
    public RosterAttributes shardId(String shardId) {
        super.shardId(shardId);
        return this;
    }

    @Override
    public RosterAttributes name(String name) {
        super.name(name);
        return this;
    }

    @Override
    public RosterAttributes stats(RosterStats stats) {
        super.stats(stats);
        return this;
    }

    @Override
    public RosterAttributes createdAt(LocalDateTime createdAt) {
        super.createdAt(createdAt);
        return this;
    }

    @Override
    public RosterAttributes titleId(String titleId) {
        super.titleId(titleId);
        return this;
    }

    public String getWon() {
        return won;
    }

    public RosterAttributes won(String won) {
        this.won = won;
        return this;
    }
}
