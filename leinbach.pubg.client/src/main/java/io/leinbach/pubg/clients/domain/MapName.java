package io.leinbach.pubg.clients.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author leinb
 * @since 1/7/2019
 */
public enum MapName {
    MIRIMAR("Desert_Main"),
    ERANGLE("Erangel_Main"),
    SANHOK("Savage_Main"),
    VIKENDI("DihorOtok_Main");

    private final String name;

    MapName(String name) {
        this.name = name;
    }

    private static final Map<String, MapName> CREATOR_MAP = new HashMap<>() {{
        Arrays.stream(MapName.values())
                .forEach(entityType -> put(entityType.name, entityType));
    }};

    @JsonCreator
    public static MapName creator(String name) {
        return CREATOR_MAP.get(name);
    }

}
