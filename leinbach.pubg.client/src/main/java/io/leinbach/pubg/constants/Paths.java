package io.leinbach.pubg.constants;

/**
 * @author leinb
 * @since 12/25/2018
 */
public class Paths {
    public static final String PLATFORM = "/shards/{platform}";
    public static final String MATCHE = PLATFORM + "/matches/{matchId}";
    public static final String PLAYERS = PLATFORM + "/players";
    public static final String PLAYER_NAMES_FILTER = "filter[playerNames]={player}";
}
