package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class LogPlayerMakeGroggy extends LogPlayerTakeDamage {
    @JsonProperty("isAttackerInVehicle")
    private final boolean attackerInVehicle;
    @JsonProperty("dBNOId")
    private final int dbnoId;

    public LogPlayerMakeGroggy(LocalDateTime eventTimestamp, EventType eventType, TelemetryCommon common, int attackId, Character attacker, Character victim, DamageTypeCategory damageTypeCategory, DamageReason damageReason, DamageCauserName damageCauserName, List<String> damageCauserAdditionalInfo, double distance, boolean attackerInVehicle, int dbnoId) {
        super(eventTimestamp, eventType, common, attackId, attacker, victim, damageTypeCategory, damageReason, damageCauserName, damageCauserAdditionalInfo, distance);
        this.attackerInVehicle = attackerInVehicle;
        this.dbnoId = dbnoId;
    }

    public boolean isAttackerInVehicle() {
        return attackerInVehicle;
    }

    public int getDbnoId() {
        return dbnoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LogPlayerMakeGroggy that = (LogPlayerMakeGroggy) o;
        return attackerInVehicle == that.attackerInVehicle &&
                dbnoId == that.dbnoId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), attackerInVehicle, dbnoId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LogPlayerMakeGroggy.class.getSimpleName() + "[", "]")
                .add("attackerInVehicle=" + attackerInVehicle)
                .add("dbnoId=" + dbnoId)
                .add("attackId=" + attackId)
                .add("attacker=" + attacker)
                .add("victim=" + victim)
                .add("damageTypeCategory=" + damageTypeCategory)
                .add("damageReason=" + damageReason)
                .add("damageCauserName=" + damageCauserName)
                .add("distance=" + distance)
                .add("damageCauserAdditionalInfo=" + damageCauserAdditionalInfo)
                .add("eventTimestamp=" + eventTimestamp)
                .add("eventType=" + eventType)
                .add("common=" + common)
                .toString();
    }
}
