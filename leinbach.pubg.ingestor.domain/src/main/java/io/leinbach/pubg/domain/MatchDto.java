package io.leinbach.pubg.domain;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author leinb
 * @since 1/6/2019
 */
public class MatchDto {
    private String id;
    private String type;
    private String telemetryUrl;

    public MatchDto() {
    }

    public MatchDto(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getTelemetryUrl() {
        return telemetryUrl;
    }

    public MatchDto telemetryUrl(String telemetryUrl) {
        this.telemetryUrl = telemetryUrl;
        return this;
    }

    public String getId() {
        return id;
    }

    public MatchDto id(String id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public MatchDto type(String type) {
        this.type = type;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchDto matchDto = (MatchDto) o;
        return Objects.equals(id, matchDto.id) &&
                Objects.equals(type, matchDto.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MatchDto.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("type='" + type + "'")
                .add("telemetryUrl='" + telemetryUrl + "'")
                .toString();
    }
}
