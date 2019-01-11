package io.leinbach.pubg.clients.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author leinb
 * @since 12/24/2018
 */
public enum Platform {

    STEAM("steam");

    private final String name;

    public String getName(){
        return name;
    }

    Platform(String name) {
        this.name = name;
    }

    private static final Map<String, Platform> CREATOR_MAP = new HashMap<>() {{
        Arrays.stream(Platform.values())
              .forEach(entityType -> put(entityType.name, entityType));
    }};

    @JsonCreator
    public static Platform creator(String name) {
        return CREATOR_MAP.get(name);
    }
    



}
