package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.leinbach.pubg.domain.EventDto;

import java.time.LocalDateTime;
import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        visible = true,
        property = "_T")
@JsonSubTypes({
        @JsonSubTypes.Type(value = LogArmorDestroy.class, name = "LogArmorDestroy"),
        @JsonSubTypes.Type(value = LogCarePackage.class, name = "LogCarePackageSpawn"),
        @JsonSubTypes.Type(value = LogCarePackage.class, name = "LogCarePackageLand"),
        @JsonSubTypes.Type(value = LogGameStatePeriodic.class, name = "LogGameStatePeriodic"),
        @JsonSubTypes.Type(value = LogItemAttachDetach.class, name = "LogItemAttach"),
        @JsonSubTypes.Type(value = LogItemAttachDetach.class, name = "LogItemDetach"),
        @JsonSubTypes.Type(value = LogItemInteract.class, name = "LogItemDrop"),
        @JsonSubTypes.Type(value = LogItemInteract.class, name = "LogItemEquip"),
        @JsonSubTypes.Type(value = LogItemInteract.class, name = "LogItemPickup"),
        @JsonSubTypes.Type(value = LogItemInteract.class, name = "LogItemPickupFromCarePackage"),
        @JsonSubTypes.Type(value = LogItemInteract.class, name = "LogItemPickupFromPlayerLootBox"),
        @JsonSubTypes.Type(value = LogItemInteract.class, name = "LogItemUnequip"),
        @JsonSubTypes.Type(value = LogItemInteract.class, name = "LogItemUse"),
        @JsonSubTypes.Type(value = LogItemInteract.class, name = "LogItemPickupFromLootBox"),
        @JsonSubTypes.Type(value = LogHeal.class, name = "LogHeal"),
        @JsonSubTypes.Type(value = LogMatchDefinition.class, name = "LogMatchDefinition"),
        @JsonSubTypes.Type(value = LogObjectDestroy.class, name = "LogObjectDestroy"),
        @JsonSubTypes.Type(value = LogMatchEnd.class, name = "LogMatchEnd"),
        @JsonSubTypes.Type(value = LogMatchStart.class, name = "LogMatchStart"),
        @JsonSubTypes.Type(value = LogParachuteLanding.class, name = "LogParachuteLanding"),
        @JsonSubTypes.Type(value = LogPlayerAttack.class, name = "LogPlayerAttack"),
        @JsonSubTypes.Type(value = LogPlayerOnlyEvent.class, name = "LogPlayerCreate"),
        @JsonSubTypes.Type(value = LogPlayerKill.class, name = "LogPlayerKill"),
        @JsonSubTypes.Type(value = LogPlayerLogInOut.class, name = "LogPlayerLogin"),
        @JsonSubTypes.Type(value = LogPlayerLogInOut.class, name = "LogPlayerLogout"),
        @JsonSubTypes.Type(value = LogPlayerMakeGroggy.class, name = "LogPlayerMakeGroggy"),
        @JsonSubTypes.Type(value = LogPlayerTakeDamage.class, name = "LogPlayerTakeDamage"),
        @JsonSubTypes.Type(value = LogPlayerPosition.class, name = "LogPlayerPosition"),
        @JsonSubTypes.Type(value = LogPlayerRevive.class, name = "LogPlayerRevive"),
        @JsonSubTypes.Type(value = LogPlayerOnlyEvent.class, name = "LogSwimStart"),
        @JsonSubTypes.Type(value = LogPlayerOnlyEvent.class, name = "LogVaultStart"),
        @JsonSubTypes.Type(value = LogRedZoneEnded.class, name = "LogRedZoneEnded"),
        @JsonSubTypes.Type(value = LogSwimEnd.class, name = "LogSwimEnd"),
        @JsonSubTypes.Type(value = LogWheelDestroy.class, name = "LogWheelDestroy"),
        @JsonSubTypes.Type(value = LogVehicleDestroy.class, name = "LogVehicleDestroy"),
        @JsonSubTypes.Type(value = LogVehicleRide.class, name = "LogVehicleRide"),
        @JsonSubTypes.Type(value = LogVehicleLeave.class, name = "LogVehicleLeave"),
        @JsonSubTypes.Type(value = LogWeaponFireCount.class, name = "LogWeaponFireCount")
})
public abstract class TelemetryBase {

    @JsonProperty("_D")
    protected LocalDateTime eventTimestamp;

    @JsonProperty("_T")
    protected EventType eventType;

    @JsonProperty("common")
    protected TelemetryCommon common;

    public void setEventTimestamp(LocalDateTime eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public void setCommon(TelemetryCommon common) {
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

    public abstract EventDto to();

    @Override
    public int hashCode() {
        return Objects.hash(eventTimestamp, eventType, common);
    }
}

