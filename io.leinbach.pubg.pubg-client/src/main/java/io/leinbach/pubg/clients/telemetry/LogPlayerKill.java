package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class LogPlayerKill extends TelemetryBase {
    @JsonProperty("attackId")
    private final int attackId;
    @JsonProperty("killer")
    private final Character killer;
    @JsonProperty("victim")
    private final Character victim;
    @JsonProperty("assistant")
    private final Character assistant;
    @JsonProperty("dBNOId")
    private final int dbnoId;
    @JsonProperty("damageTypeCategory")
    private final DamageTypeCategory damageTypeCategory;
    @JsonProperty("damageCauserName")
    private final DamageCauserName damageCauserName;
    @JsonProperty("damageCauserAdditionalInfo")
    private final List<String> damageCauserAdditionalInfo;
    @JsonProperty("damageReason")
    private final DamageReason damageReason;
    @JsonProperty("distance")
    private final double distance;
    @JsonProperty("victimGameResult")
    private final GameResult gameResult;

    public LogPlayerKill(LocalDateTime eventTimestamp, EventType eventType, TelemetryCommon common, int attackId, Character killer, Character victim, Character assistant, int dbnoId, DamageTypeCategory damageTypeCategory, DamageCauserName damageCauserName, List<String> damageCauserAdditionalInfo, DamageReason damageReason, double distance, GameResult gameResult) {
        super(eventTimestamp, eventType, common);
        this.attackId = attackId;
        this.killer = killer;
        this.victim = victim;
        this.assistant = assistant;
        this.dbnoId = dbnoId;
        this.damageTypeCategory = damageTypeCategory;
        this.damageCauserName = damageCauserName;
        this.damageCauserAdditionalInfo = damageCauserAdditionalInfo;
        this.damageReason = damageReason;
        this.distance = distance;
        this.gameResult = gameResult;
    }

    public int getAttackId() {
        return attackId;
    }

    public Character getKiller() {
        return killer;
    }

    public Character getVictim() {
        return victim;
    }

    public Character getAssistant() {
        return assistant;
    }

    public int getDbnoId() {
        return dbnoId;
    }

    public DamageTypeCategory getDamageTypeCategory() {
        return damageTypeCategory;
    }

    public DamageCauserName getDamageCauserName() {
        return damageCauserName;
    }

    public List<String> getDamageCauserAdditionalInfo() {
        return damageCauserAdditionalInfo;
    }

    public DamageReason getDamageReason() {
        return damageReason;
    }

    public double getDistance() {
        return distance;
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LogPlayerKill that = (LogPlayerKill) o;
        return attackId == that.attackId &&
                dbnoId == that.dbnoId &&
                Double.compare(that.distance, distance) == 0 &&
                Objects.equals(killer, that.killer) &&
                Objects.equals(victim, that.victim) &&
                Objects.equals(assistant, that.assistant) &&
                damageTypeCategory == that.damageTypeCategory &&
                damageCauserName == that.damageCauserName &&
                Objects.equals(damageCauserAdditionalInfo, that.damageCauserAdditionalInfo) &&
                damageReason == that.damageReason &&
                Objects.equals(gameResult, that.gameResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), attackId, killer, victim, assistant, dbnoId, damageTypeCategory, damageCauserName, damageCauserAdditionalInfo, damageReason, distance, gameResult);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LogPlayerKill.class.getSimpleName() + "[", "]")
                .add("attackId=" + attackId)
                .add("killer=" + killer)
                .add("victim=" + victim)
                .add("assistant=" + assistant)
                .add("dbnoId=" + dbnoId)
                .add("damageTypeCategory=" + damageTypeCategory)
                .add("damageCauserName=" + damageCauserName)
                .add("damageCauserAdditionalInfo=" + damageCauserAdditionalInfo)
                .add("damageReason=" + damageReason)
                .add("distance=" + distance)
                .add("gameResult=" + gameResult)
                .add("eventTimestamp=" + eventTimestamp)
                .add("eventType=" + eventType)
                .add("common=" + common)
                .toString();
    }
}
