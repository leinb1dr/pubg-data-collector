package io.leinbach.pubg.clients.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * @author leinb
 * @since 1/17/2019
 */
public class GameModeStats extends Stats {
    @JsonProperty("duo")
    private Map<String, Object> duo;
    @JsonProperty("duo-fpp")
    private Map<String, Object> duoFpp;
    @JsonProperty("solo")
    private Map<String, Object> solo;
    @JsonProperty("solo-fpp")
    private Map<String, Object> soloFpp;
    @JsonProperty("squad")
    private Map<String, Object> squad;
    @JsonProperty("squad-fpp")
    private Map<String, Object> squadFpp;

    public Map<String, Object> getDuo() {
        return duo;
    }

    public GameModeStats duo(Map<String, Object> duo) {
        this.duo = duo;
        return this;
    }

    public Map<String, Object> getDuoFpp() {
        return duoFpp;
    }

    public GameModeStats duoFpp(Map<String, Object> duoFpp) {
        this.duoFpp = duoFpp;
        return this;
    }

    public Map<String, Object> getSolo() {
        return solo;
    }

    public GameModeStats solo(Map<String, Object> solo) {
        this.solo = solo;
        return this;
    }

    public Map<String, Object> getSoloFpp() {
        return soloFpp;
    }

    public GameModeStats soloFpp(Map<String, Object> soloFpp) {
        this.soloFpp = soloFpp;
        return this;
    }

    public Map<String, Object> getSquad() {
        return squad;
    }

    public GameModeStats squad(Map<String, Object> squad) {
        this.squad = squad;
        return this;
    }

    public Map<String, Object> getSquadFpp() {
        return squadFpp;
    }

    public GameModeStats squadFpp(Map<String, Object> squadFpp) {
        this.squadFpp = squadFpp;
        return this;
    }
}
