package io.leinbach.pubg.clients.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.leinbach.pubg.domain.MatchDto;
import io.leinbach.pubg.domain.ParticipantsDto;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatchEntity extends PubgEntity<MatchAttributes, MatchRelationships> {

    public MatchDto to() {
        return new MatchDto()
                .id(id)
                .gameMode(attributes != null ? attributes.getGameMode().getCode():null)
                .matchDate(attributes != null ? attributes.getCreatedAt() :  null)
                .map(attributes != null ? attributes.getMapName().name() : null)
                .type(type.name());
    }


}
