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
                .type(type.name());
    }


}
