package io.leinbach.pubg.clients.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author leinb
 * @since 1/7/2019
 */
public enum SeasonState {
    CLOSED("closed"),
    PREPARE("prepare"),
    PROGRESS("progress");

    private final String name;

    SeasonState(String name) {
        this.name = name;
    }

    private static final Map<String, SeasonState> CREATOR_MAP = new HashMap<>() {{
        Arrays.stream(SeasonState.values())
                .forEach(entityType -> put(entityType.name, entityType));
    }};

    @JsonCreator
    public static SeasonState creator(String name) {
        return CREATOR_MAP.get(name);
    }

}
