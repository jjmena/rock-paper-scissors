package com.ciklum.rock_paper_scissors.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ciklum.rock_paper_scissors.domain.GameOption.PAPER;
import static com.ciklum.rock_paper_scissors.domain.GameOption.ROCK;
import static com.ciklum.rock_paper_scissors.domain.GameOption.SCISSORS;
import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    private static Stream<Arguments> gameOptionParameters() {
        return Stream.of(
                Arguments.of(ROCK, ROCK, Result.DRAW),
                Arguments.of(PAPER, PAPER, Result.DRAW),
                Arguments.of(SCISSORS, SCISSORS, Result.DRAW),
                Arguments.of(ROCK, PAPER, Result.WINNER_PLAYER2),
                Arguments.of(ROCK, SCISSORS, Result.WINNER_PLAYER1),
                Arguments.of(PAPER, ROCK, Result.WINNER_PLAYER1),
                Arguments.of(PAPER, SCISSORS, Result.WINNER_PLAYER2),
                Arguments.of(SCISSORS, ROCK, Result.WINNER_PLAYER2),
                Arguments.of(SCISSORS, PAPER, Result.WINNER_PLAYER1)
        );
    }

    @ParameterizedTest
    @MethodSource("gameOptionParameters")
    void shouldCalculateRoundResult(GameOption player1Option, GameOption player2Option, Result expected) {
        // When
        Result result = Result.winner(player1Option, player2Option);

        // Then
        assertThat(result).isEqualTo(expected);

    }

}
