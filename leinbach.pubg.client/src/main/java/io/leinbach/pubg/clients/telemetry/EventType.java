package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EventType {
    LOGARMORDESTROY,
    LOGCAREPACKAGELAND,
    LOGCAREPACKAGESPAWN,
    LOGGAMESTATEPERIODIC,
    LOGHEAL,
    LOGITEMATTACH,
    LOGITEMDETACH,
    LOGITEMDROP,
    LOGITEMEQUIP,
    LOGITEMPICKUP,
    LOGITEMPICKUPFROMCAREPACKAGE,
    LOGITEMPICKUPFROMLOOTBOX,
    LOGITEMUNEQUIP,
    LOGITEMUSE,
    LOGMATCHDEFINITION,
    LOGMATCHEND,
    LOGMATCHSTART,
    LOGOBJECTDESTROY,
    LOGPARACHUTELANDING,
    LOGPLAYERATTACK,
    LOGPLAYERCREATE,
    LOGPLAYERKILL,
    LOGPLAYERLOGIN,
    LOGPLAYERLOGOUT,
    LOGPLAYERMAKEGROGGY,
    LOGPLAYERPOSITION,
    LOGPLAYERREVIVE,
    LOGPLAYERTAKEDAMAGE,
    LOGREDZONEENDED,
    LOGSWIMEND,
    LOGSWIMSTART,
    LOGVAULTSTART,
    LOGVEHICLEDESTROY,
    LOGVEHICLELEAVE,
    LOGVEHICLERIDE,
    LOGWEAPONFIRECOUNT,
    LOGWHEELDESTROY;

    @JsonCreator
    public static EventType creator(String eventName) {
        return EventType.valueOf(eventName.toUpperCase());
    }
}