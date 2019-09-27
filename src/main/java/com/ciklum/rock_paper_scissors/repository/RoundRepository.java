package com.ciklum.rock_paper_scissors.repository;

import com.ciklum.rock_paper_scissors.domain.Round;
import com.ciklum.rock_paper_scissors.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class RoundRepository {

    private static final List<Round> rounds = new ArrayList<>();

    public Round create(Round.RoundBuilder roundBuilder) {
        Round round = roundBuilder.roundId(UUID.randomUUID().toString()).build();
        rounds.add(round);
        round.getResult().incrementAndGet();
        return round;
    }

    public Optional<Round> findByRoundId(String roundId) {
        return rounds.stream().filter(r -> r.getRoundId().equals(roundId)).findFirst();
    }

    public int removeByUser(User user) {
        List<Round> roundsToRemove = rounds.stream().filter(r -> r.getUser().equals(user)).collect(Collectors.toList());
        rounds.removeAll(roundsToRemove);
        return roundsToRemove.size();
    }

}
