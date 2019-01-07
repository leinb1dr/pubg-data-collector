package io.leinbach.pubg.clients.domain;

import java.util.ArrayList;

/**
 * @author leinb
 * @since 12/25/2018
 */
public class PlayerListResult extends DataList<PubgPlayer> {

    public PlayerListResult() {
        this.setData(new ArrayList<>());
    }
}
