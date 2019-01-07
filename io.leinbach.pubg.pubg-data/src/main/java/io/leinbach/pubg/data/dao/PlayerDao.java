package io.leinbach.pubg.data.dao;

import io.leinbach.pubg.data.entity.Player;
import io.leinbach.pubg.domain.PlayerDto;
import org.springframework.data.cassandra.core.ReactiveCassandraOperations;
import org.springframework.data.cassandra.core.cql.ReactiveCqlTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author leinb
 * @since 12/27/2018
 */
@Component
public class PlayerDao {

    private final ReactiveCassandraOperations operations;
    private final ReactiveCqlTemplate template;

    public PlayerDao(ReactiveCassandraOperations operations, ReactiveCqlTemplate template) {
        this.operations = operations;
        this.template = template;
    }

    public Mono<PlayerDto> getPlayer(String name) {
//        return operations.selectOne("SELECT * FROM player WHERE username = 'stealthg0d'", Player.class);
        return template.queryForObject("SELECT * FROM player WHERE username = ?",
                (row, rowNum) -> new Player(row.getString("username"), row.getString("pubgid")),
                name)
                .map(Player::to);
    }

    public Mono<PlayerDto> createPlayer(PlayerDto player) {
        return operations.insert(new Player(player.getId(), player.getName()))
                .map(Player::to);
    }

    public Mono<PlayerDto> deletePlayer(String name) {
        return operations.delete(new Player(name, ""))
                .map(Player::to);
    }
}
