package io.leinbach.pubg.clients.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.time.LocalDateTime;
import java.util.StringJoiner;

/**
 * @author leinb
 * @since 1/7/2019
 */
public class Attributes<T extends Stats> {


    public Attributes(String shardId, String name, T stats, LocalDateTime createdAt, String titleId) {
        this.shardId = shardId;
        this.name = name;
        this.stats = stats;
        this.createdAt = createdAt;
        this.titleId = titleId;
    }

    /**
     * platform shard
     */
    @JsonProperty("shardId")
    @JsonPropertyDescription("platform shard")
    protected String shardId;
    /**
     * PUBG IGN
     */
    @JsonProperty("name")
    @JsonPropertyDescription("PUBG IGN")
    protected String name;
    /**
     * N/A
     */
    @JsonProperty("stats")
    @JsonPropertyDescription("N/A")
    protected T stats;
    /**
     * N/A
     */
    @JsonProperty("createdAt")
    @JsonPropertyDescription("N/A")
    protected LocalDateTime createdAt;
    /**
     * Identifies the studio and game
     */
    @JsonProperty("titleId")
    @JsonPropertyDescription("Identifies the studio and game")
    protected String titleId;

    public Attributes() {
    }

    public String getShardId() {
        return shardId;
    }

    public Attributes<T> shardId(String shardId) {
        this.shardId = shardId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Attributes<T> name(String name) {
        this.name = name;
        return this;
    }

    public T getStats() {
        return stats;
    }

    public Attributes<T> stats(T stats) {
        this.stats = stats;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Attributes<T> createdAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getTitleId() {
        return titleId;
    }

    public Attributes<T> titleId(String titleId) {
        this.titleId = titleId;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Attributes.class.getSimpleName() + "[", "]")
                .add("shardId='" + shardId + "'")
                .add("name='" + name + "'")
                .add("stats=" + stats)
                .add("createdAt=" + createdAt)
                .add("titleId='" + titleId + "'")
                .toString();
    }
}
