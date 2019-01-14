package io.leinbach.pubg.data.entity;

import io.leinbach.pubg.domain.AttackDto;
import io.leinbach.pubg.domain.CharacterDto;
import io.leinbach.pubg.domain.EventDto;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * @author leinb
 * @since 1/10/2019
 */
@Table("heatMap")
public class HeatMap {

    @PrimaryKey
    private HeatMapId id;
    private int attackId;
    private String character_name;
    private double damage;

    public HeatMap() {
    }

    public HeatMap(HeatMapId id, int attackId, String character_name, double damage) {
        this.id = id;
        this.attackId = attackId;
        this.character_name = character_name;
        this.damage = damage;
    }

    public static HeatMap from(EventDto eventDto) {
        CharacterDto character = eventDto.getCharacter();
        AttackDto attack = eventDto.getAttack();

        return new HeatMap()
                .heatMapId(new HeatMapId()
                        .matchId(eventDto.getMatchId())
                        .character_accountId(character.getAccountId())
                        .damageReason(attack.getDamageReason())
                        .eventTimestamp(eventDto.getTimestamp()))
                .attackId(eventDto.getAttackId())
                .character_name(character.getName())
                .damage(attack.getDamage());

    }


    public HeatMapId getId() {
        return id;
    }

    public HeatMap heatMapId(HeatMapId heatMapId) {
        this.id = heatMapId;
        return this;
    }

    public int getAttackId() {
        return attackId;
    }

    public HeatMap attackId(int attackId) {
        this.attackId = attackId;
        return this;
    }

    public String getCharacter_name() {
        return character_name;
    }

    public HeatMap character_name(String character_name) {
        this.character_name = character_name;
        return this;
    }

    public double getDamage() {
        return damage;
    }

    public HeatMap damage(double damage) {
        this.damage = damage;
        return this;
    }
}
