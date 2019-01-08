package io.leinbach.pubg.clients.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author leinb
 * @since 1/8/2019
 */
public class AssetAttributes extends Attributes {
    @JsonProperty("description")
    private String description;
    @JsonProperty("URL")
    private String url;

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssetAttributes that = (AssetAttributes) o;
        return Objects.equals(description, that.description) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, url);
    }

    public AssetAttributes() {
    }

    public AssetAttributes(String shardId, String name, Stats stats, LocalDateTime createdAt, String titleId, String description, String url) {
        super(shardId, name, stats, createdAt, titleId);
        this.description = description;
        this.url = url;
    }

    @Override
    public AssetAttributes shardId(String shardId) {
        super.shardId(shardId);
        return this;
    }

    @Override
    public AssetAttributes name(String name) {
        super.name(name);
        return this;
    }

    @Override
    public AssetAttributes stats(Stats stats) {
        super.stats(stats);
        return this;
    }

    @Override
    public AssetAttributes createdAt(LocalDateTime createdAt) {
        super.createdAt(createdAt);
        return this;
    }

    @Override
    public AssetAttributes titleId(String titleId) {
        super.titleId(titleId);
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AssetAttributes descripiton(String descripiton) {
        this.description = descripiton;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public AssetAttributes url(String url) {
        this.url = url;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AssetAttributes.class.getSimpleName() + "[", "]")
                .add("description='" + description + "'")
                .add("url='" + url + "'")
                .add("shardId='" + shardId + "'")
                .add("name='" + name + "'")
                .add("stats=" + stats)
                .add("createdAt=" + createdAt)
                .add("titleId='" + titleId + "'")
                .toString();
    }
}
