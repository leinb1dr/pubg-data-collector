package io.leinbach.pubg.clients.domain;

import java.util.StringJoiner;

/**
 * @author leinb
 * @since 1/7/2019
 */
public class Relationships {


    @Override
    public String toString() {
        return new StringJoiner(", ", Relationships.class.getSimpleName() + "[", "]")
                .toString();
    }
}
