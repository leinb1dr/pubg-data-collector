package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.leinbach.pubg.domain.EventDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class LogPlayerMakeGroggy extends LogPlayerTakeDamage {
    @JsonProperty("isAttackerInVehicle")
    private boolean attackerInVehicle;
    @JsonProperty("dBNOId")
    private int dbnoId;

    @Override
    public EventDto to() {
        EventDto to = super.to()
                .dbnoId(dbnoId);
        to.getCharacter()
                .attackerInVehicle(attackerInVehicle);

        return to;
    }

    public boolean isAttackerInVehicle() {
        return attackerInVehicle;
    }

    public void setAttackerInVehicle(boolean attackerInVehicle) {
        this.attackerInVehicle = attackerInVehicle;
    }

    public int getDbnoId() {
        return dbnoId;
    }

    public void setDbnoId(int dbnoId) {
        this.dbnoId = dbnoId;
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
