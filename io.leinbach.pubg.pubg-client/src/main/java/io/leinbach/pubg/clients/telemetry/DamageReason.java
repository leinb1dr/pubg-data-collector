package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum DamageReason {
    ARM_SHOT("ArmShot"),
    HEAD_SHOT("HeadShot"),
    LEG_SHOT("LegShot"),
    NONE("None"),
    NON_SPECIFIC("NonSpecific"),
    PELVIS_SHOT("PelvisShot"),
    TORSO_SHOT("TorsoShot");

    private final String name;

    DamageReason(String name) {
        this.name = name;
    }

    private static final Map<String, DamageReason> CREATOR_MAP = new HashMap<>() {{
        Arrays.stream(DamageReason.values())
                .forEach(entityType -> put(entityType.name, entityType));
    }};

    @JsonCreator
    public static DamageReason creator(String name) {
        return CREATOR_MAP.get(name);
    }

}
