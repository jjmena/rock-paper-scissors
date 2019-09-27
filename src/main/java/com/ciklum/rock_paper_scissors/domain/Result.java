package com.ciklum.rock_paper_scissors.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

@AllArgsConstructor
@Getter
public enum Result {
    WINNER_PLAYER1(new AtomicInteger(0)), WINNER_PLAYER2(new AtomicInteger(0)), DRAW(new AtomicInteger(0));

    private AtomicInteger counter;

    public static Result winner(GameOption player1Option, GameOption player2Option) {
        if (player1Option == player2Option) {
            return DRAW;
        }
        if (player1Option == GameOption.ROCK && player2Option == GameOption.SCISSORS) {
            return WINNER_PLAYER1;
        }
        if (player1Option == GameOption.PAPER && player2Option == GameOption.ROCK) {
            return WINNER_PLAYER1;
        }
        if (player1Option == GameOption.SCISSORS && player2Option == GameOption.PAPER) {
            return WINNER_PLAYER1;
        }
        return WINNER_PLAYER2;
    }

    public static Map<Result, Integer> stats() {
        return Arrays.stream(Result.values()).collect(Collectors.toMap(identity(), r -> r.getCounter().get()));
    }

    public int updateStats() {
        return this.counter.incrementAndGet();
    }
}
