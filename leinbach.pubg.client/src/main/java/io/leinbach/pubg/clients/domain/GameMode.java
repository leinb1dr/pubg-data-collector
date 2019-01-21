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
    
    DUO("duo", "duo"),
    DUO_FPP("duo-fpp", "duoFpp"),
    SOLO("solo", "solo"),
    SOLO_FPP("solo-fpp", "soloFpp"),
    SQUAD("squad", "squad"),
    SQUAD_FPP("squad-fpp", "squadFpp"),
    NORMAL_DUO("normal-duo", "normalDuo"),
    NORMAL_DUO_FPP("normal-duo-fpp", "normalDuoFpp"),
    NORMAL_SOLO("normal-solo", "normalSolo"),
    NORMAL_SOLO_FPP("normal-solo-fpp", "normalSoloFpp"),
    NORMAL_SQUAD("normal-squad", "normalSquad"),
    NORMAL_SQUAD_FPP("normal-squad-fpp", "normalSquadFpp");
    
    
    private final String name;
    private final String code;

    GameMode(String name, String code) {
        this.name = name;
        this.code = code;
    }

    private static final Map<String, GameMode> CREATOR_MAP = new HashMap<>() {{
        Arrays.stream(GameMode.values())
                .forEach(entityType -> put(entityType.name, entityType));
    }};

    @JsonCreator
    public static GameMode creator(String name) {
        return CREATOR_MAP.get(name);
    }

    public String getCode() {
        return code;
    }
}
