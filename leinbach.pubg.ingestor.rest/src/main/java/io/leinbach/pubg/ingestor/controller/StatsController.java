package io.leinbach.pubg.ingestor.controller;

import io.leinbach.pubg.data.dao.HeatMapDao;
import io.leinbach.pubg.domain.HeatMapDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author leinb
 * @since 1/14/2019
 */
@RestController
public class StatsController {

    private final HeatMapDao heatMapDao;

    public StatsController(HeatMapDao heatMapDao) {
        this.heatMapDao = heatMapDao;

    }

    @GetMapping("/player/{accountId}/matches/{matchId}/heatmap")
    public Mono<HeatMapDto> getHeatMap(@PathVariable String accountId, @PathVariable String matchId){
        return heatMapDao.getHeatMap(accountId, matchId);
    }
}
