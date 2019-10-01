package com.ciklum.rock_paper_scissors.repository;

import com.ciklum.rock_paper_scissors.domain.Round;
import com.ciklum.rock_paper_scissors.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class RoundRepository {

    private static final Map<String, Round> rounds = new ConcurrentHashMap<>();

    public Round create(Round.RoundBuilder roundBuilder) {
        Round round = roundBuilder.roundId(UUID.randomUUID().toString()).build();
        rounds.put(round.getRoundId(), round);
        round.getResult().updateStats();
        return round;
    }

    public Optional<Round> findByRoundId(String roundId) {
        return Optional.ofNullable(rounds.get(roundId));
    }

    public int removeByUser(User user) {
        Set<Map.Entry<String, Round>> roundsToRemove = rounds.entrySet()
                .stream()
                .filter(e -> e.getValue().getUser().equals(user))
                .collect(Collectors.toSet());
        rounds.entrySet().removeAll(roundsToRemove);
        return roundsToRemove.size();
    }

}
