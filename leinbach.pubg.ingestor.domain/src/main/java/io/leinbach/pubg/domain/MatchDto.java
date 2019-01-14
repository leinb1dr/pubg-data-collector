package io.leinbach.pubg.domain;

import java.util.List;
import java.util.Map;
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
    private int rank;
    private int teamId;
    private Map<String, Double> stats;
    private List<ParticipantsDto> participants;

    public int getRank() {
        return rank;
    }

    public MatchDto rank(int rank) {
        this.rank = rank;
        return this;
    }

    public int getTeamId() {
        return teamId;
    }

    public MatchDto teamId(int teamId) {
        this.teamId = teamId;
        return this;
    }

    public Map<String, Double> getStats() {
        return stats;
    }

    public MatchDto stats(Map<String, Double> stats) {
        this.stats = stats;
        return this;
    }

    public List<ParticipantsDto> getParticipants() {
        return participants;
    }

    public MatchDto participants(List<ParticipantsDto> participants) {
        this.participants = participants;
        return this;
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
