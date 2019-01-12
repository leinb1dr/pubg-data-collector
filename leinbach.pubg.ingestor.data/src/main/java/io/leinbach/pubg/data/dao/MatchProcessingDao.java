package io.leinbach.pubg.data.dao;

import io.leinbach.pubg.data.entity.MatchProcessing;
import io.leinbach.pubg.data.repository.MatchProcessingRepository;
import io.leinbach.pubg.domain.MatchDto;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * @author leinb
 * @since 1/11/2019
 */
@Component
public class MatchProcessingDao {

    private final MatchProcessingRepository matchProcessingRepository;

    public MatchProcessingDao(MatchProcessingRepository matchProcessingRepository) {
        this.matchProcessingRepository = matchProcessingRepository;
    }

    public Mono<Boolean> needsProcessing(MatchDto matchDto) {
        return matchProcessingRepository.findById(matchDto.getId())
                .map(MatchProcessing::needsProcessing)
                .switchIfEmpty(Mono.just(true));
    }

    public Mono<MatchDto> markForProcessing(MatchDto matchDto) {
        return matchProcessingRepository.save(new MatchProcessing(matchDto.getId(), 1, 1, LocalDateTime.now()))
                .map(ignore -> matchDto);
    }
}
