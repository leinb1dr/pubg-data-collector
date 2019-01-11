package io.leinbach.pubg.clients.domain;

import java.util.ArrayList;

/**
 * @author leinb
 * @since 12/25/2018
 */
public class PlayerListResult extends DataList<PlayerEntity> {

    public PlayerListResult() {
        this.setData(new ArrayList<>());
    }
}
