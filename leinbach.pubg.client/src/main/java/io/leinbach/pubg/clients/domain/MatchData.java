package io.leinbach.pubg.clients.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author leinb
 * @since 1/7/2019
 */
public class MatchData extends Data<MatchEntity>{

    @JsonProperty("included")
    private List<? extends PubgEntity> included;



    public List<? extends PubgEntity> getIncluded() {
        return included;
    }

    public MatchData included(List<? extends PubgEntity> included) {
        this.included = included;
        return this;
    }

    @Override
    public MatchData data(MatchEntity data) {
        super.data(data);
        return this;
    }

    @Override
    public MatchData links(Links links) {
        super.links(links);
        return this;
    }

    @Override
    public MatchData meta(Map<String, Object> meta) {
        super.meta(meta);
        return this;
    }

    public MatchData() {
    }

    public MatchData(MatchEntity data, Links links, Map<String, Object> meta, List<PubgEntity<Attributes, Relationships>> included) {
        super(data, links, meta);
        this.included = included;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MatchData matchData = (MatchData) o;
        return Objects.equals(included, matchData.included);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), included);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MatchData.class.getSimpleName() + "[", "]")
                .add("included=" + included)
                .add("data=" + data)
                .add("links=" + links)
                .add("meta=" + meta)
                .toString();
    }
}
