package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum DamageTypeCategory {
    DAMAGE_BLUEZONE,
    DAMAGE_DROWN,
    DAMAGE_EXPLOSION_GRENADE,
    DAMAGE_EXPLOSION_REDZONE,
    DAMAGE_EXPLOSION_VEHICLE,
    DAMAGE_GROGGY,
    DAMAGE_GUN,
    DAMAGE_INSTANT_FALL,
    DAMAGE_MELEE,
    DAMAGE_MOLOTOV,
    DAMAGE_PUNCH,
    DAMAGE_VEHICLECRASHHIT,
    DAMAGE_VEHICLEHIT;

    private static final Logger LOGGER = LoggerFactory.getLogger(DamageTypeCategory.class);

    @JsonCreator
    public static DamageTypeCategory creator(String eventName) {
        try {
            return DamageTypeCategory.valueOf(eventName.toUpperCase());
        } catch (Exception e){
            LOGGER.error("Could not deserialize enum", e);
        }
        return null;
    }
}
