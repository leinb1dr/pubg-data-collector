package io.leinbach.pubg.domain;

import java.util.StringJoiner;

/**
 * @author leinb
 * @since 1/9/2019
 */
public class EventDto {
    private String accountId;
    private int attackId;
    private int dbnoId;
    private int ownerTeamId;
    private String matchId;
    private CharacterDto character;
    private CharacterDto target;
    private CharacterDto assistant;
    private ItemDto item;
    private ItemDto attachment;
    private AttackDto attack;
    private ItemPackageDto itemPackage;
    private GameStateDto gameState;
    private VehicleDto vehicle;
    private double healAmount;
    private String pingQuality;
    private String seasonState;
    private double distance;
    private double elapsedTime;


    public double getElapsedTime() {
        return elapsedTime;
    }

    public EventDto elapsedTime(double elapsedTime) {
        this.elapsedTime = elapsedTime;
        return this;
    }

    public VehicleDto getVehicle() {
        return vehicle;
    }

    public EventDto vehicle(VehicleDto vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public EventDto healAmount(double healAmount) {
        this.healAmount = healAmount;
        return this;
    }

    public double getDistance() {
        return distance;
    }

    public EventDto distance(double distance) {
        this.distance = distance;
        return this;
    }

    public String getMatchId() {
        return matchId;
    }

    public EventDto matchId(String matchId) {
        this.matchId = matchId;
        return this;
    }

    public String getPingQuality() {
        return pingQuality;
    }

    public EventDto pingQuality(String pingQuality) {
        this.pingQuality = pingQuality;
        return this;
    }

    public String getSeasonState() {
        return seasonState;
    }

    public EventDto seasonState(String seasonState) {
        this.seasonState = seasonState;
        return this;
    }

    public int getOwnerTeamId() {
        return ownerTeamId;
    }

    public EventDto ownerTeamId(int ownerTeamId) {
        this.ownerTeamId = ownerTeamId;
        return this;
    }

    public Double getHealAmount() {
        return healAmount;
    }

    public EventDto healAmount(Double healAmount) {
        this.healAmount = healAmount;
        return this;
    }

    public GameStateDto getGameState() {
        return gameState;
    }

    public EventDto gameState(GameStateDto gameStateDto) {
        this.gameState = gameStateDto;
        return this;
    }

    public ItemPackageDto getItemPackage() {
        return itemPackage;
    }

    public EventDto itemPackage(ItemPackageDto itemPackage) {
        this.itemPackage = itemPackage;
        return this;
    }

    public String getAccountId() {
        return accountId;
    }

    public EventDto accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public int getAttackId() {
        return attackId;
    }

    public EventDto attackId(int attackId) {
        this.attackId = attackId;
        return this;
    }

    public int getDbnoId() {
        return dbnoId;
    }

    public EventDto dbnoId(int dbnoId) {
        this.dbnoId = dbnoId;
        return this;
    }

    public CharacterDto getCharacter() {
        return character;
    }

    public EventDto character(CharacterDto character) {
        this.character = character;
        return this;
    }

    public CharacterDto getTarget() {
        return target;
    }

    public EventDto target(CharacterDto target) {
        this.target = target;
        return this;
    }

    public CharacterDto getAssistant() {
        return assistant;
    }

    public EventDto assistant(CharacterDto assistant) {
        this.assistant = assistant;
        return this;
    }

    public ItemDto getItem() {
        return item;
    }

    public EventDto item(ItemDto item) {
        this.item = item;
        return this;
    }

    public ItemDto getAttachment() {
        return attachment;
    }

    public EventDto attachment(ItemDto attachment) {
        this.attachment = attachment;
        return this;
    }

    public AttackDto getAttack() {
        return attack;
    }

    public EventDto attack(AttackDto attack) {
        this.attack = attack;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", EventDto.class.getSimpleName() + "[", "]")
                .add("accountId='" + accountId + "'")
                .add("attackId=" + attackId)
                .add("dbnoId=" + dbnoId)
                .add("ownerTeamId=" + ownerTeamId)
                .add("matchId='" + matchId + "'")
                .add("character=" + character)
                .add("target=" + target)
                .add("assistant=" + assistant)
                .add("item=" + item)
                .add("attachment=" + attachment)
                .add("attack=" + attack)
                .add("itemPackage=" + itemPackage)
                .add("gameState=" + gameState)
                .add("vehicle=" + vehicle)
                .add("healAmount=" + healAmount)
                .add("pingQuality='" + pingQuality + "'")
                .add("seasonState='" + seasonState + "'")
                .add("distance=" + distance)
                .add("elapsedTime=" + elapsedTime)
                .toString();
    }
}
