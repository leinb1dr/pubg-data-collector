package io.leinbach.pubg.clients.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author leinb
 * @since 1/7/2019
 */
public class MatchRelationships extends Relationships {
    @JsonProperty("rosters")
    private DataList<RosterEntity> rosters;
    @JsonProperty("assets")
    private DataList<AssetEntity> assets;



    public MatchRelationships() {
    }

    public MatchRelationships(DataList<RosterEntity> rosters) {
        this.rosters = rosters;
    }

    public MatchRelationships(DataList<RosterEntity> rosters, DataList<AssetEntity> assets) {
        this.rosters = rosters;
        this.assets = assets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchRelationships that = (MatchRelationships) o;
        return Objects.equals(rosters, that.rosters) &&
                Objects.equals(assets, that.assets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rosters, assets);
    }

    public DataList<AssetEntity> getAssets() {
        return assets;
    }

    public MatchRelationships assets(DataList<AssetEntity> assets) {
        this.assets = assets;
        return this;
    }

    public DataList<RosterEntity> getRosters() {
        return rosters;
    }

    public MatchRelationships rosters(DataList<RosterEntity> rosters) {
        this.rosters = rosters;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MatchRelationships.class.getSimpleName() + "[", "]")
                .add("rosters=" + rosters)
                .add("assets=" + assets)
                .toString();
    }
}
