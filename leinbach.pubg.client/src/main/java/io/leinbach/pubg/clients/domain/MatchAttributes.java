package io.leinbach.pubg.clients.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.StringJoiner;

/**
 * @author leinb
 * @since 1/7/2019
 */
public class MatchAttributes extends Attributes<Stats> {

    @JsonProperty("duration")
    private Integer duration;
    @JsonProperty("gameMode")
    private GameMode gameMode;
    @JsonProperty("mapName")
    private MapName mapName;
    @JsonProperty("isCustomMatch")
    private Boolean customMatch;
    @JsonProperty("patchVersion")
    private String patchVersion;
    @JsonProperty("seasonState")
    private SeasonState seasonState;
    @JsonProperty("tags")
    private Map<String, Object> tags;

    public MatchAttributes() {
    }

    public MatchAttributes(String shardId, String name, Stats stats, LocalDateTime createdAt, String titleId, Integer duration, GameMode gameMode, MapName mapName, Boolean customMatch, String patchVersion, SeasonState seasonState, Map<String, Object> tags) {
        super(shardId, name, stats, createdAt, titleId);
        this.duration = duration;
        this.gameMode = gameMode;
        this.mapName = mapName;
        this.customMatch = customMatch;
        this.patchVersion = patchVersion;
        this.seasonState = seasonState;
        this.tags = tags;
    }

    public Integer getDuration() {
        return duration;
    }

    public MatchAttributes duration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public MatchAttributes gameMode(GameMode gameMode) {
        this.gameMode = gameMode;
        return this;
    }

    public MapName getMapName() {
        return mapName;
    }

    public MatchAttributes mapName(MapName mapName) {
        this.mapName = mapName;
        return this;
    }

    public Boolean getCustomMatch() {
        return customMatch;
    }

    public MatchAttributes customMatch(Boolean customMatch) {
        this.customMatch = customMatch;
        return this;
    }

    public String getPatchVersion() {
        return patchVersion;
    }

    public MatchAttributes patchVersion(String patchVersion) {
        this.patchVersion = patchVersion;
        return this;
    }

    public SeasonState getSeasonState() {
        return seasonState;
    }

    public MatchAttributes seasonState(SeasonState seasonState) {
        this.seasonState = seasonState;
        return this;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public MatchAttributes tags(Map<String, Object> tags) {
        this.tags = tags;
        return this;
    }

    @Override
    public MatchAttributes titleId(String titleId) {
        super.titleId(titleId);
        return this;
    }

    @Override
    public MatchAttributes shardId(String shardId) {
        super.shardId(shardId);
        return this;
    }

    @Override
    public MatchAttributes name(String name) {
        super.name(name);
        return this;
    }

    @Override
    public MatchAttributes stats(Stats stats) {
        super.stats(stats);
        return this;
    }

    @Override
    public MatchAttributes createdAt(LocalDateTime createdAt) {
        super.createdAt(createdAt);
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MatchAttributes.class.getSimpleName() + "[", "]")
                .add("shardId='" + shardId + "'")
                .add("name='" + name + "'")
                .add("stats=" + stats)
                .add("createdAt=" + createdAt)
                .toString();
    }
}
