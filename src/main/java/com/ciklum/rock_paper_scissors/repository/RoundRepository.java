package com.ciklum.rock_paper_scissors.repository;

import com.ciklum.rock_paper_scissors.domain.Round;
import com.ciklum.rock_paper_scissors.domain.User;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.UUID;

public interface RoundRepository extends Repository<Round, String> {


    default Round create(Round.RoundBuilder roundBuilder) {
        Round round = this.save(roundBuilder.roundId(UUID.randomUUID().toString()).build());
        round.getResult().updateStats();
        return round;
    }

    default int removeByUser(User user) {
        return deleteByUser(user);
    }

    Round save(Round round);

    int deleteByUser(User user);

    Optional<Round> findByRoundId(String roundId);

}
