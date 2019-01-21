package io.leinbach.pubg.clients.domain;

/**
 * @author leinb
 * @since 1/16/2019
 */
public class SeasonRelationships extends Relationships {

    private Player player;
    private MatchListResult matchesSquad;
    private MatchListResult matchesSquadFPP;
    private MatchListResult matchesSolo;
    private MatchListResult matchesSoloFPP;
    private MatchListResult matchesDuo;
    private MatchListResult matchesDuoFPP;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public MatchListResult getMatchesSquad() {
        return matchesSquad;
    }

    public void setMatchesSquad(MatchListResult matchesSquad) {
        this.matchesSquad = matchesSquad;
    }

    public MatchListResult getMatchesSquadFPP() {
        return matchesSquadFPP;
    }

    public void setMatchesSquadFPP(MatchListResult matchesSquadFPP) {
        this.matchesSquadFPP = matchesSquadFPP;
    }

    public MatchListResult getMatchesSolo() {
        return matchesSolo;
    }

    public void setMatchesSolo(MatchListResult matchesSolo) {
        this.matchesSolo = matchesSolo;
    }

    public MatchListResult getMatchesSoloFPP() {
        return matchesSoloFPP;
    }

    public void setMatchesSoloFPP(MatchListResult matchesSoloFPP) {
        this.matchesSoloFPP = matchesSoloFPP;
    }

    public MatchListResult getMatchesDuo() {
        return matchesDuo;
    }

    public void setMatchesDuo(MatchListResult matchesDuo) {
        this.matchesDuo = matchesDuo;
    }

    public MatchListResult getMatchesDuoFPP() {
        return matchesDuoFPP;
    }

    public void setMatchesDuoFPP(MatchListResult matchesDuoFPP) {
        this.matchesDuoFPP = matchesDuoFPP;
    }
}
