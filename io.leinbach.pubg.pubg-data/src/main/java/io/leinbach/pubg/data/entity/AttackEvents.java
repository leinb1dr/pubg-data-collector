package io.leinbach.pubg.data.entity;

import io.leinbach.pubg.domain.CharacterDto;
import io.leinbach.pubg.domain.EventDto;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author leinb
 * @since 1/10/2019
 */
@Table("attack")
public class AttackEvents {

    @PrimaryKey
    private String matchId;
    private LocalDateTime timestamp;
    private String eventType;
    private int attackId;
    private String character_name;
    private int character_teamId;
    private double character_health;
    private int character_ranking;
    private String character_accountId;
    private boolean character_isInBlueZone;
    private boolean character_isInRedZone;
    private Set<String> character_zone;
    private String target_name;
    private int target_teamId;
    private double target_health;
    private int target_ranking;
    private String target_accountId;
    private boolean target_isInBlueZone;
    private boolean target_isInRedZone;
    private Set<String> target_zone;
    private String damageTypeCategory;
    private String damageReason;
    private String damageCauserName;
    private String damageCauserNameCategory;
    private double distance;

    public AttackEvents() {
    }

    public AttackEvents(String matchId, LocalDateTime timestamp, String eventType, int attackId, String character_name, int character_teamId, double character_health, int character_ranking, String character_accountId, boolean character_isInBlueZone, boolean character_isInRedZone, Set<String> character_zone, String target_name, int target_teamId, double target_health, int target_ranking, String target_accountId, boolean target_isInBlueZone, boolean target_isInRedZone, Set<String> target_zone, String damageTypeCategory, String damageReason, String damageCauserName, String damageCauserNameCategory, double distance) {
        this.matchId = matchId;
        this.timestamp = timestamp;
        this.eventType = eventType;
        this.attackId = attackId;
        this.character_name = character_name;
        this.character_teamId = character_teamId;
        this.character_health = character_health;
        this.character_ranking = character_ranking;
        this.character_accountId = character_accountId;
        this.character_isInBlueZone = character_isInBlueZone;
        this.character_isInRedZone = character_isInRedZone;
        this.character_zone = character_zone;
        this.target_name = target_name;
        this.target_teamId = target_teamId;
        this.target_health = target_health;
        this.target_ranking = target_ranking;
        this.target_accountId = target_accountId;
        this.target_isInBlueZone = target_isInBlueZone;
        this.target_isInRedZone = target_isInRedZone;
        this.target_zone = target_zone;
        this.damageTypeCategory = damageTypeCategory;
        this.damageReason = damageReason;
        this.damageCauserName = damageCauserName;
        this.damageCauserNameCategory = damageCauserNameCategory;
        this.distance = distance;
    }

    public static AttackEvents from(EventDto eventDto) {
        CharacterDto character = eventDto.getCharacter();
        CharacterDto target = eventDto.getTarget();
        return new AttackEvents()
                .attackId(eventDto.getAttackId())
                .timestamp(eventDto.getTimestamp())
                .eventType(eventDto.getEventName())
                .attackId(eventDto.getAttackId())
                .character_name(character.getName())
                .character_teamId(character.getTeamId())
                .character_health(character.getHealth())
                .character_ranking(character.getRank())
                .character_accountId(character.getAccountId())
                .character_isInBlueZone(character.isInBlueZone())
                .character_isInRedZone(character.isInRedZone())
                .character_zone(new HashSet<>(character.getZone()));
    }

    public String getMatchId() {
        return matchId;
    }

    public AttackEvents matchId(String matchId) {
        this.matchId = matchId;
        return this;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public AttackEvents timestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getEventType() {
        return eventType;
    }

    public AttackEvents eventType(String eventType) {
        this.eventType = eventType;
        return this;
    }

    public int getAttackId() {
        return attackId;
    }

    public AttackEvents attackId(int attackId) {
        this.attackId = attackId;
        return this;
    }

    public String getCharacter_name() {
        return character_name;
    }

    public AttackEvents character_name(String character_name) {
        this.character_name = character_name;
        return this;
    }

    public int getCharacter_teamId() {
        return character_teamId;
    }

    public AttackEvents character_teamId(int character_teamId) {
        this.character_teamId = character_teamId;
        return this;
    }

    public double getCharacter_health() {
        return character_health;
    }

    public AttackEvents character_health(double character_health) {
        this.character_health = character_health;
        return this;
    }

    public int getCharacter_ranking() {
        return character_ranking;
    }

    public AttackEvents character_ranking(int character_ranking) {
        this.character_ranking = character_ranking;
        return this;
    }

    public String getCharacter_accountId() {
        return character_accountId;
    }

    public AttackEvents character_accountId(String character_accountId) {
        this.character_accountId = character_accountId;
        return this;
    }

    public boolean isCharacter_isInBlueZone() {
        return character_isInBlueZone;
    }

    public AttackEvents character_isInBlueZone(boolean character_isInBlueZone) {
        this.character_isInBlueZone = character_isInBlueZone;
        return this;
    }

    public boolean isCharacter_isInRedZone() {
        return character_isInRedZone;
    }

    public AttackEvents character_isInRedZone(boolean character_isInRedZone) {
        this.character_isInRedZone = character_isInRedZone;
        return this;
    }

    public Set<String> getCharacter_zone() {
        return character_zone;
    }

    public AttackEvents character_zone(Set<String> character_zone) {
        this.character_zone = character_zone;
        return this;
    }

    public String getTarget_name() {
        return target_name;
    }

    public AttackEvents target_name(String target_name) {
        this.target_name = target_name;
        return this;
    }

    public int getTarget_teamId() {
        return target_teamId;
    }

    public AttackEvents target_teamId(int target_teamId) {
        this.target_teamId = target_teamId;
        return this;
    }

    public double getTarget_health() {
        return target_health;
    }

    public AttackEvents target_health(double target_health) {
        this.target_health = target_health;
        return this;
    }

    public int getTarget_ranking() {
        return target_ranking;
    }

    public AttackEvents target_ranking(int target_ranking) {
        this.target_ranking = target_ranking;
        return this;
    }

    public String getTarget_accountId() {
        return target_accountId;
    }

    public AttackEvents target_accountId(String target_accountId) {
        this.target_accountId = target_accountId;
        return this;
    }

    public boolean isTarget_isInBlueZone() {
        return target_isInBlueZone;
    }

    public AttackEvents target_isInBlueZone(boolean target_isInBlueZone) {
        this.target_isInBlueZone = target_isInBlueZone;
        return this;
    }

    public boolean isTarget_isInRedZone() {
        return target_isInRedZone;
    }

    public AttackEvents target_isInRedZone(boolean target_isInRedZone) {
        this.target_isInRedZone = target_isInRedZone;
        return this;
    }

    public Set<String> getTarget_zone() {
        return target_zone;
    }

    public AttackEvents target_zone(Set<String> target_zone) {
        this.target_zone = target_zone;
        return this;
    }

    public String getDamageTypeCategory() {
        return damageTypeCategory;
    }

    public AttackEvents damageTypeCategory(String damageTypeCategory) {
        this.damageTypeCategory = damageTypeCategory;
        return this;
    }

    public String getDamageReason() {
        return damageReason;
    }

    public AttackEvents damageReason(String damageReason) {
        this.damageReason = damageReason;
        return this;
    }

    public String getDamageCauserName() {
        return damageCauserName;
    }

    public AttackEvents damageCauserName(String damageCauserName) {
        this.damageCauserName = damageCauserName;
        return this;
    }

    public String getDamageCauserNameCategory() {
        return damageCauserNameCategory;
    }

    public AttackEvents damageCauserNameCategory(String damageCauserNameCategory) {
        this.damageCauserNameCategory = damageCauserNameCategory;
        return this;
    }

    public double getDistance() {
        return distance;
    }

    public AttackEvents distance(double distance) {
        this.distance = distance;
        return this;
    }
}
