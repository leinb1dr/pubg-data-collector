package io.leinbach.pubg.clients.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author leinb
 * @since 1/7/2019
 */
public class RosterRelationships extends Relationships {
    @JsonProperty("participants")
    private DataList<ParticipantEntity> participants;
    @JsonProperty("team")
    private DataList<PubgEntity> team;

    public DataList<ParticipantEntity> getParticipants() {
        return participants;
    }

    public RosterRelationships participants(DataList<ParticipantEntity> participants) {
        this.participants = participants;
        return this;
    }

    public DataList<PubgEntity> getTeam() {
        return team;
    }

    public RosterRelationships team(DataList<PubgEntity> team) {
        this.team = team;
        return this;
    }

    public RosterRelationships() {
    }

    public RosterRelationships(DataList<ParticipantEntity> participants, DataList<PubgEntity> team) {
        this.participants = participants;
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RosterRelationships that = (RosterRelationships) o;
        return Objects.equals(participants, that.participants) &&
                Objects.equals(team, that.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participants, team);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RosterRelationships.class.getSimpleName() + "[", "]")
                .add("participants=" + participants)
                .add("team=" + team)
                .toString();
    }
}
