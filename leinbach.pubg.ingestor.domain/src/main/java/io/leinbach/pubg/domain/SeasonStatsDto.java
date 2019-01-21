package io.leinbach.pubg.domain;

import java.util.Map;

/**
 * @author leinb
 * @since 1/17/2019
 */
public class SeasonStatsDto {
    private Map<String, Object> duo;
    private Map<String, Object> duoFpp;
    private Map<String, Object> solo;
    private Map<String, Object> soloFpp;
    private Map<String, Object> squad;
    private Map<String, Object> squadFpp;

    public Map<String, Object> getDuo() {
        return duo;
    }

    public SeasonStatsDto duo(Map<String, Object> duo) {
        this.duo = duo;
        return this;
    }

    public Map<String, Object> getDuoFpp() {
        return duoFpp;
    }

    public SeasonStatsDto duoFpp(Map<String, Object> duoFpp) {
        this.duoFpp = duoFpp;
        return this;
    }

    public Map<String, Object> getSolo() {
        return solo;
    }

    public SeasonStatsDto solo(Map<String, Object> solo) {
        this.solo = solo;
        return this;
    }

    public Map<String, Object> getSoloFpp() {
        return soloFpp;
    }

    public SeasonStatsDto soloFpp(Map<String, Object> soloFpp) {
        this.soloFpp = soloFpp;
        return this;
    }

    public Map<String, Object> getSquad() {
        return squad;
    }

    public SeasonStatsDto squad(Map<String, Object> squad) {
        this.squad = squad;
        return this;
    }

    public Map<String, Object> getSquadFpp() {
        return squadFpp;
    }

    public SeasonStatsDto squadFpp(Map<String, Object> squadFpp) {
        this.squadFpp = squadFpp;
        return this;
    }
}
