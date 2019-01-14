package io.leinbach.pubg.domain;

import java.util.Map;

/**
 * @author leinb
 * @since 1/14/2019
 */
public class HeatMapDto {
    private Map<String, HeatMapStatsDto> damageMap;

    public Map<String, HeatMapStatsDto> getDamageMap() {
        return damageMap;
    }

    public HeatMapDto damageMap(Map<String, HeatMapStatsDto> damageMap) {
        this.damageMap = damageMap;
        return this;
    }
}
