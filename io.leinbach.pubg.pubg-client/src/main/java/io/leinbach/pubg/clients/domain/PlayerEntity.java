package io.leinbach.pubg.clients.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.leinbach.pubg.domain.PlayerDto;

import java.util.stream.Collectors;


/**
 * Player Object
 * <p>
 * Player objects contain information about a player and a list of their recent matches (up to 14 days old). Note: player objects are specific to platform shards.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerEntity extends PubgEntity<PlayerAttributes, PlayerRelationships> {

    public PlayerDto to() {
        return new PlayerDto()
                .id(id)
                .name(attributes.getName())
                .matches(relationships
                        .getMatches()
                        .getData()
                        .stream()
                        .map(MatchEntity::to)
                        .collect(Collectors.toList()));
    }

    @Override
    public PlayerEntity type(EntityType type) {
        super.type(type);
        return this;
    }

    @Override
    public PlayerEntity id(String id) {
        super.id(id);
        return this;
    }

    @Override
    public PlayerEntity attributes(PlayerAttributes attributes) {
        super.attributes(attributes);
        return this;
    }

    @Override
    public PlayerEntity relationships(PlayerRelationships relationships) {
        super.relationships(relationships);
        return this;
    }

    @Override
    public PlayerEntity links(Links links) {
        super.links(links);
        return this;
    }
}
