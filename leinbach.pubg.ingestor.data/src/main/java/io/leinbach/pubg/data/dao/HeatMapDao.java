package io.leinbach.pubg.data.dao;

import io.leinbach.pubg.data.entity.HeatMap;
import io.leinbach.pubg.data.entity.HeatMapStat;
import io.leinbach.pubg.data.repository.HeatMapRepository;
import io.leinbach.pubg.domain.EventDto;
import io.leinbach.pubg.domain.HeatMapDto;
import org.springframework.data.cassandra.core.ReactiveCassandraOperations;
import org.springframework.data.cassandra.core.ReactiveCassandraTemplate;
import org.springframework.data.cassandra.core.cql.ReactiveCqlTemplate;
import org.springframework.data.cassandra.core.query.CriteriaDefinitions;
import org.springframework.data.cassandra.core.query.Query;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author leinb
 * @since 1/10/2019
 */
@Component
public class HeatMapDao {
    private final HeatMapRepository repository;
    private final ReactiveCqlTemplate template;
    private final ReactiveCassandraTemplate ops;

    public HeatMapDao(HeatMapRepository repository, ReactiveCqlTemplate template, ReactiveCassandraTemplate ops) {
        this.repository = repository;
        this.template = template;
        this.ops = ops;
    }

    public Mono<EventDto> saveHeatmap(EventDto eventDto) {
        return repository.save(HeatMap.from(eventDto))
                .map(event -> eventDto);
    }

    public Mono<HeatMapDto> getHeatMap(String accountId, String matchId) {

        return template.queryForRows("select damageReason, AVG(damage) as averageDamage, SUM(damage) as totalDamage, COUNT(*) as attackCount from HeatMap " +
                "where character_accountId = ? and matchId = ? GROUP BY character_accountId, matchId, damageReason", accountId, matchId)
                .map(row -> new HeatMapStat(row.getString("damageReason"),
                        row.getDouble("averageDamage"),
                        row.getDouble("totalDamage"),
                        (int)row.getLong("attackCount")))
                .collectMap(HeatMapStat::getDamageReason, HeatMapStat::to)
                .map(map -> new HeatMapDto().damageMap(map));
    }
}
