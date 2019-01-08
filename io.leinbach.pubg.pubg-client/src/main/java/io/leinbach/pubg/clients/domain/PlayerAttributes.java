package io.leinbach.pubg.clients.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerAttributes extends Attributes<PlayerStats> {

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

    public PlayerAttributes() {
    }

    public PlayerAttributes(String shardId, String name, PlayerStats stats, LocalDateTime createdAt, LocalDateTime updatedAt, String patchVersion, String titleId) {
        super(shardId, name, stats, createdAt, titleId);
        this.updatedAt = updatedAt;
        this.patchVersion = patchVersion;
    }

    @Override
    public PlayerAttributes shardId(String shardId) {
        this.shardId = shardId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerAttributes that = (PlayerAttributes) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getStats(), that.getStats()) &&
                Objects.equals(getCreatedAt(), that.getCreatedAt()) &&
                Objects.equals(updatedAt, that.updatedAt) &&
                Objects.equals(patchVersion, that.patchVersion) &&
                Objects.equals(titleId, that.titleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getStats(), getCreatedAt(), updatedAt, patchVersion, titleId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PlayerAttributes.class.getSimpleName() + "[", "]")
                .add("name='" + getName() + "'")
                .add("shardId='" + getShardId() + "'")
                .add("stats=" + getStats())
                .add("createdAt=" + getCreatedAt())
                .add("updatedAt=" + updatedAt)
                .add("patchVersion='" + patchVersion + "'")
                .add("titleId='" + titleId + "'")
                .toString();
    }

    @Override
    public PlayerAttributes name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public PlayerAttributes stats(PlayerStats stats) {
        this.stats = stats;
        return this;
    }

    @Override
    public PlayerAttributes createdAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public PlayerAttributes updatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getPatchVersion() {
        return patchVersion;
    }

    public PlayerAttributes patchVersion(String patchVersion) {
        this.patchVersion = patchVersion;
        return this;
    }

    @Override
    public PlayerAttributes titleId(String titleId) {
        super.titleId(titleId);
        return this;
    }
}
