package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.leinbach.pubg.domain.AttackDto;
import io.leinbach.pubg.domain.EventDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class LogPlayerKill extends TelemetryBase {
    @JsonProperty("attackId")
    private int attackId;
    @JsonProperty("killer")
    private Character killer;
    @JsonProperty("victim")
    private Character victim;
    @JsonProperty("assistant")
    private Character assistant;
    @JsonProperty("dBNOId")
    private int dbnoId;
    @JsonProperty("damageTypeCategory")
    private DamageTypeCategory damageTypeCategory;
    @JsonProperty("damageCauserName")
    private DamageCauserName damageCauserName;
    @JsonProperty("damageCauserAdditionalInfo")
    private List<String> damageCauserAdditionalInfo;
    @JsonProperty("damageReason")
    private DamageReason damageReason;
    @JsonProperty("distance")
    private double distance;
    @JsonProperty("victimGameResult")
    private GameResult gameResult;

    @Override
    public EventDto to() {
        return super.to()
                .attackId(attackId)
                .character(killer.to())
                .target(victim.to()
                        .gameResult(gameResult.getGameResult())
                        .rank(gameResult.getRank())
                        .stats(gameResult.getStats()
                                .to())
                )
                .assistant(assistant.to())
                .dbnoId(dbnoId)
                .attack(new AttackDto()
                        .damageTypeCategory(damageTypeCategory.name())
                        .damageCauserName(damageCauserName.getKey()
                                .toUpperCase())
                        .damageCauserType(damageCauserName.getName()
                                .toUpperCase())
                        .damageCauserAdditionalInfo(damageCauserAdditionalInfo)
                        .damageReason(damageReason.name())
                        .distance(distance)
                );
    }

    public int getAttackId() {
        return attackId;
    }

    public void setAttackId(int attackId) {
        this.attackId = attackId;
    }

    public Character getKiller() {
        return killer;
    }

    public void setKiller(Character killer) {
        this.killer = killer;
    }

    public Character getVictim() {
        return victim;
    }

    public void setVictim(Character victim) {
        this.victim = victim;
    }

    public Character getAssistant() {
        return assistant;
    }

    public void setAssistant(Character assistant) {
        this.assistant = assistant;
    }

    public int getDbnoId() {
        return dbnoId;
    }

    public void setDbnoId(int dbnoId) {
        this.dbnoId = dbnoId;
    }

    public DamageTypeCategory getDamageTypeCategory() {
        return damageTypeCategory;
    }

    public void setDamageTypeCategory(DamageTypeCategory damageTypeCategory) {
        this.damageTypeCategory = damageTypeCategory;
    }

    public DamageCauserName getDamageCauserName() {
        return damageCauserName;
    }

    public void setDamageCauserName(DamageCauserName damageCauserName) {
        this.damageCauserName = damageCauserName;
    }

    public List<String> getDamageCauserAdditionalInfo() {
        return damageCauserAdditionalInfo;
    }

    public void setDamageCauserAdditionalInfo(List<String> damageCauserAdditionalInfo) {
        this.damageCauserAdditionalInfo = damageCauserAdditionalInfo;
    }

    public DamageReason getDamageReason() {
        return damageReason;
    }

    public void setDamageReason(DamageReason damageReason) {
        this.damageReason = damageReason;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    public void setGameResult(GameResult gameResult) {
        this.gameResult = gameResult;
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
