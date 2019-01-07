package io.leinbach.pubg.clients.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Attributes {

    /**
     * PUBG IGN
     */
    @JsonProperty("name")
    @JsonPropertyDescription("PUBG IGN")
    private String name;
    /**
     * platform shard
     */
    @JsonProperty("shardId")
    @JsonPropertyDescription("platform shard")
    private String shardId;
    /**
     * N/A
     */
    @JsonProperty("stats")
    @JsonPropertyDescription("N/A")
    private Stats stats;
    /**
     * N/A
     */
    @JsonProperty("createdAt")
    @JsonPropertyDescription("N/A")
    private LocalDateTime createdAt;
    /**
     * N/A
     */
    @JsonProperty("updatedAt")
    @JsonPropertyDescription("N/A")
    private LocalDateTime updatedAt;
    /**
     * Version of the game
     */
    @JsonProperty("patchVersion")
    @JsonPropertyDescription("Version of the game")
    private String patchVersion;
    /**
     * Identifies the studio and game
     */
    @JsonProperty("titleId")
    @JsonPropertyDescription("Identifies the studio and game")
    private String titleId;

    @Override
    public String toString() {
        return new StringJoiner(", ", Attributes.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("shardId='" + shardId + "'")
                .add("stats=" + stats)
                .add("createdAt='" + createdAt + "'")
                .add("updatedAt='" + updatedAt + "'")
                .add("patchVersion='" + patchVersion + "'")
                .add("titleId='" + titleId + "'")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attributes that = (Attributes) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(shardId, that.shardId) &&
                Objects.equals(stats, that.stats) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt) &&
                Objects.equals(patchVersion, that.patchVersion) &&
                Objects.equals(titleId, that.titleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, shardId, stats, createdAt, updatedAt, patchVersion, titleId);
    }

    public String getName() {
        return name;
    }

    public Attributes setName(String name) {
        this.name = name;
        return this;
    }

    public String getShardId() {
        return shardId;
    }

    public Attributes setShardId(String shardId) {
        this.shardId = shardId;
        return this;
    }

    public Stats getStats() {
        return stats;
    }

    public Attributes setStats(Stats stats) {
        this.stats = stats;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Attributes setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Attributes setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getPatchVersion() {
        return patchVersion;
    }

    public Attributes setPatchVersion(String patchVersion) {
        this.patchVersion = patchVersion;
        return this;
    }

    public String getTitleId() {
        return titleId;
    }

    public Attributes setTitleId(String titleId) {
        this.titleId = titleId;
        return this;
    }

}
