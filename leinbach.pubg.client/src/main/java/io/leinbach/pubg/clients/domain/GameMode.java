package io.leinbach.pubg.clients.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author leinb
 * @since 1/7/2019
 */
public enum GameMode {
    
    DUO("duo"),
    DUO_FPP("duo-fpp"),
    SOLO("solo"),
    SOLO_FPP("solo-fpp"),
    SQUAD("squad"),
    SQUAD_FPP("squad-fpp"),
    NORMAL_DUO("normal-duo"),
    NORMAL_DUO_FPP("normal-duo-fpp"),
    NORMAL_SOLO("normal-solo"),
    NORMAL_SOLO_FPP("normal-solo-fpp"),
    NORMAL_SQUAD("normal-squad"),
    NORMAL_SQUAD_FPP("normal-squad-fpp");
    
    
    private final String name;

    GameMode(String name) {
        this.name = name;
    }

    private static final Map<String, GameMode> CREATOR_MAP = new HashMap<>() {{
        Arrays.stream(GameMode.values())
                .forEach(entityType -> put(entityType.name, entityType));
    }};

    @JsonCreator
    public static GameMode creator(String name) {
        return CREATOR_MAP.get(name);
    }
    
}
