package io.leinbach.pubg.clients.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author leinb
 * @since 12/24/2018
 */
public enum EntityType {
    PLAYER("player"),
    MATCH("match"),
    ROSTER("roster"),
    PARTICIPANT("participant"),
    ASSET("asset");


    private String name;

    EntityType(String name) {
        this.name = name;
    }

    private static final Map<String, EntityType> CREATOR_MAP = new HashMap<>(){{
        Arrays.stream(EntityType.values()).forEach(entityType -> put(entityType.name, entityType));
    }};

    @JsonCreator
    public static EntityType creator(String name){
        return CREATOR_MAP.get(name);
    }
}
