package io.leinbach.pubg.data.dao;

import io.leinbach.pubg.data.entity.Player;
import io.leinbach.pubg.data.repository.PlayerRepository;
import io.leinbach.pubg.domain.PlayerDto;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.util.Logger;
import reactor.util.Loggers;

/**
 * @author leinb
 * @since 12/27/2018
 */
@Component
public class PlayerDao {

    private final Logger LOGGER = Loggers.getLogger(PlayerDao.class);

    private final PlayerRepository playerRepository;

    public PlayerDao(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    public Mono<PlayerDto> getPlayer(String name) {
        return playerRepository.findById(name)
                .map(Player::to);
    }

    public Mono<PlayerDto> savePlayer(PlayerDto player) {
        return playerRepository.save(Player.from(player))
                .map(Player::to);
//                .doOnError(throwable -> LOGGER.error("failed to save player", throwable));
    }

    public Mono<Void> deletePlayer(String name) {
        return playerRepository.deleteById(name);
    }

    public Mono<PlayerDto> getPlayerById(String accountId) {
        return playerRepository.findByAccountId(accountId)
                .map(Player::to);
    }
}
