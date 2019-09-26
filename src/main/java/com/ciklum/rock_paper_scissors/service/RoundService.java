package com.ciklum.rock_paper_scissors.service;

import com.ciklum.rock_paper_scissors.domain.GameOption;
import com.ciklum.rock_paper_scissors.domain.Result;
import com.ciklum.rock_paper_scissors.domain.Round;
import com.ciklum.rock_paper_scissors.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class RoundService {
    private final GameOptionGenerator player1GameOptionGenerator;
    private final GameOptionGenerator player2GameOptionGenerator;

    public Round create(User user) {
        GameOption player1GameOption = player1GameOptionGenerator.playRound();
        GameOption player2GameOption = player2GameOptionGenerator.playRound();

        // TODO: Pending store round information

        return Round.builder()
                .roundId(UUID.randomUUID().toString())
                .firstPlayerOption(player1GameOption)
                .secondPlayerOption(player2GameOption)
                .user(user)
                .result(Result.winner(player1GameOption, player2GameOption))
                .build();
    }
}
