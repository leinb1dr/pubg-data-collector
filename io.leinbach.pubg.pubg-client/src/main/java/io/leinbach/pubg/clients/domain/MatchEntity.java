package io.leinbach.pubg.clients.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.leinbach.pubg.domain.MatchDto;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatchEntity extends PubgEntity<MatchAttributes, MatchRelationships>{

    public MatchDto to() {
        return new MatchDto(id, type.name());
    }



}
