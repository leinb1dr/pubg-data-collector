package io.leinbach.pubg.clients.domain;

import io.leinbach.pubg.domain.MatchDto;
import io.leinbach.pubg.domain.PlayerDto;
import io.leinbach.pubg.domain.SeasonStatsDto;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author leinb
 * @since 1/16/2019
 */
public class PlayerSeasonEntity extends PubgEntity<SeasonAttributes, SeasonRelationships> {

    public PlayerDto to() {
        var stats = attributes.getGameModeStats();
        var relationships = this.relationships;

        var duo = Stream.concat(relationships.getMatchesDuo()
                .getData()
                .stream(), relationships.getMatchesDuoFPP()
                .getData()
                .stream())
                .map(MatchEntity::to);
        var solo = Stream.concat(relationships.getMatchesSolo()
                .getData()
                .stream(), relationships.getMatchesSoloFPP()
                .getData()
                .stream())
                .map(MatchEntity::to);
        var squad = Stream.concat(relationships.getMatchesSquad()
                .getData()
                .stream(), relationships.getMatchesSquadFPP()
                .getData()
                .stream())
                .map(MatchEntity::to);

        var matches = Stream.concat(duo, Stream.concat(solo, squad))
                .collect(Collectors.toList());

        return new PlayerDto()
                .id(relationships.getPlayer()
                        .getData()
                        .getId())
                .matches(matches)
                .seasonStats(new SeasonStatsDto()
                        .solo(stats.getSolo())
                        .soloFpp(stats.getSoloFpp())
                        .duo(stats.getDuo())
                        .duoFpp(stats.getDuoFpp())
                        .squad(stats.getSquad())
                        .squadFpp(stats.getSquadFpp())
                );
    }
}
