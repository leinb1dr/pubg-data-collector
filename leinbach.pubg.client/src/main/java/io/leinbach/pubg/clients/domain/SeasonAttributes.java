package io.leinbach.pubg.clients.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author leinb
 * @since 1/16/2019
 */
public class SeasonAttributes extends Attributes<GameModeStats>{

    @JsonProperty("gameModeStats")
    private GameModeStats gameModeStats;

    public GameModeStats getGameModeStats() {
        return gameModeStats;
    }

    public SeasonAttributes gameModeStats(GameModeStats gameModeStats) {
        this.gameModeStats = gameModeStats;
        return this;
    }

}
