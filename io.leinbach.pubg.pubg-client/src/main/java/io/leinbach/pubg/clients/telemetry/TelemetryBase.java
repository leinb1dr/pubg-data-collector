package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDateTime;
import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        visible = true,
        property = "_T")
@JsonSubTypes({
        @JsonSubTypes.Type(value = LogArmorDestroy.class, name = "LOGARMORDESTROY"),
        @JsonSubTypes.Type(value = LogCarePackage.class, name = "LOGCAREPACKAGELAND"),
        @JsonSubTypes.Type(value = LogCarePackage.class, name = "LOGCAREPACKAGESPAWN"),
        @JsonSubTypes.Type(value = LogGameStatePeriodic.class, name = "LOGGAMESTATEPERIODIC"),
        @JsonSubTypes.Type(value = LogItemAttachDetach.class, name = "LOGITEMATTACH"),
        @JsonSubTypes.Type(value = LogItemAttachDetach.class, name = "LOGITEMDETACH"),
        @JsonSubTypes.Type(value = LogItemInteract.class, name = "LOGITEMDROP"),
        @JsonSubTypes.Type(value = LogItemInteract.class, name = "LOGITEMEQUIP"),
        @JsonSubTypes.Type(value = LogItemInteract.class, name = "LOGITEMPICKUP"),
        @JsonSubTypes.Type(value = LogItemInteract.class, name = "LOGITEMPICKUPFROMCAREPACKAGE"),
        @JsonSubTypes.Type(value = LogItemInteract.class, name = "LOGITEMPICKUPFROMLOOTBOX"),
        @JsonSubTypes.Type(value = LogItemInteract.class, name = "LOGITEMUNEQUIP"),
        @JsonSubTypes.Type(value = LogItemInteract.class, name = "LOGITEMUSE"),
        @JsonSubTypes.Type(value = LogHeal.class, name = "LOGHEAL"),
        @JsonSubTypes.Type(value = LogMatchDefinition.class, name = "LOGMATCHDEFINITION"),
        @JsonSubTypes.Type(value = LogMatchEnd.class, name = "LOGMATCHEND"),
        @JsonSubTypes.Type(value = LogMatchStart.class, name = "LOGMATCHSTART"),
        @JsonSubTypes.Type(value = LogParachuteLanding.class, name = "LOGPARACHUTELANDING"),
        @JsonSubTypes.Type(value = LogPlayerAttack.class, name = "LOGPLAYERATTACK"),
        @JsonSubTypes.Type(value = LogPlayerOnlyEvent.class, name = "LOGPLAYERCREATE"),
        @JsonSubTypes.Type(value = LogPlayerKill.class, name = "LOGPLAYERKILL"),
        @JsonSubTypes.Type(value = LogPlayerLogInOut.class, name = "LOGPLAYERLOGIN"),
        @JsonSubTypes.Type(value = LogPlayerLogInOut.class, name = "LOGPLAYERLOGOUT"),
        @JsonSubTypes.Type(value = LogPlayerMakeGroggy.class, name = "LOGPLAYERMAKEGROGGY"),
        @JsonSubTypes.Type(value = LogPlayerTakeDamage.class, name = "LOGPLAYERTAKEDAMAGE"),
        @JsonSubTypes.Type(value = LogPlayerPosition.class, name = "LOGPLAYERPOSITION"),
        @JsonSubTypes.Type(value = LogPlayerRevive.class, name = "LOGPLAYERREVIVE"),
        @JsonSubTypes.Type(value = LogPlayerOnlyEvent.class, name = "LOGSWIMSTART"),
        @JsonSubTypes.Type(value = LogPlayerOnlyEvent.class, name = "LOGVAULTSTART"),
        @JsonSubTypes.Type(value = LogRedZoneEnded.class, name = "LOGREDZONEENDED"),
        @JsonSubTypes.Type(value = LogSwimEnd.class, name = "LOGSWIMEND"),
        @JsonSubTypes.Type(value = LogWheelDestroy.class, name = "LOGWHEELDESTROY"),
        @JsonSubTypes.Type(value = LogVehicleDestroy.class, name = "LOGVEHICLEDESTROY"),
        @JsonSubTypes.Type(value = LogVehicleRide.class, name = "LOGVEHICLERIDE"),
        @JsonSubTypes.Type(value = LogVehicleLeave.class, name = "LOGVEHICLELEAVE"),
        @JsonSubTypes.Type(value = LogWeaponFireCount.class, name = "LOGWEAPONFIRECOUNT")
})
public abstract class TelemetryBase {

    @JsonProperty("_D")
    protected final LocalDateTime eventTimestamp;

    @JsonProperty("_T")
    protected final EventType eventType;

    @JsonProperty("common")
    protected final TelemetryCommon common;

    public TelemetryBase(LocalDateTime eventTimestamp, EventType eventType, TelemetryCommon common) {
        this.eventTimestamp = eventTimestamp;
        this.eventType = eventType;
        this.common = common;
    }

    public LocalDateTime getEventTimestamp() {
        return eventTimestamp;
    }

    public EventType getEventType() {
        return eventType;
    }

    public TelemetryCommon getCommon() {
        return common;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelemetryBase that = (TelemetryBase) o;
        return Objects.equals(eventTimestamp, that.eventTimestamp) &&
                eventType == that.eventType &&
                Objects.equals(common, that.common);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventTimestamp, eventType, common);
    }
}

