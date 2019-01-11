package io.leinbach.pubg.data.entity;

import io.leinbach.pubg.domain.AttackDto;
import io.leinbach.pubg.domain.CharacterDto;
import io.leinbach.pubg.domain.EventDto;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author leinb
 * @since 1/10/2019
 */
@Table("damagePlayer")
public class DamagePlayer {

    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String matchId;
    @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String character_accountId;
    @PrimaryKeyColumn(ordinal = 2, type = PrimaryKeyType.PARTITIONED)
    private String damageReason;
    @PrimaryKeyColumn(ordinal = 3, type = PrimaryKeyType.CLUSTERED)
    private LocalDateTime eventTimestamp;
    private int attackId;
    private String character_name;
    private double damage;

    public DamagePlayer() {
    }

    public DamagePlayer(String matchId, String character_accountId, String damageReason, LocalDateTime eventTimestamp, int attackId, String character_name, double damage) {
        this.matchId = matchId;
        this.character_accountId = character_accountId;
        this.damageReason = damageReason;
        this.eventTimestamp = eventTimestamp;
        this.attackId = attackId;
        this.character_name = character_name;
        this.damage = damage;
    }

    public static DamagePlayer from(EventDto eventDto) {
        CharacterDto character = eventDto.getCharacter();
        AttackDto attack = eventDto.getAttack();

        return new DamagePlayer()
                .matchId(eventDto.getMatchId())
                .character_accountId(character.getAccountId())
                .damageReason(attack.getDamageReason())
                .eventTimestamp(eventDto.getTimestamp())
                .attackId(eventDto.getAttackId())
                .character_name(character.getName())
                .damage(attack.getDamage());

    }


    public String getMatchId() {
        return matchId;
    }

    public DamagePlayer matchId(String matchId) {
        this.matchId = matchId;
        return this;
    }

    public String getCharacter_accountId() {
        return character_accountId;
    }

    public DamagePlayer character_accountId(String character_accountId) {
        this.character_accountId = character_accountId;
        return this;
    }

    public String getDamageReason() {
        return damageReason;
    }

    public DamagePlayer damageReason(String damageReason) {
        this.damageReason = damageReason;
        return this;
    }

    public LocalDateTime getEventTimestamp() {
        return eventTimestamp;
    }

    public DamagePlayer eventTimestamp(LocalDateTime eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
        return this;
    }

    public int getAttackId() {
        return attackId;
    }

    public DamagePlayer attackId(int attackId) {
        this.attackId = attackId;
        return this;
    }

    public String getCharacter_name() {
        return character_name;
    }

    public DamagePlayer character_name(String character_name) {
        this.character_name = character_name;
        return this;
    }

    public double getDamage() {
        return damage;
    }

    public DamagePlayer damage(double damage) {
        this.damage = damage;
        return this;
    }
}
