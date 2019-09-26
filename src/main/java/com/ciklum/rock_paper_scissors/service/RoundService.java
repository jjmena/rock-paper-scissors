package com.ciklum.rock_paper_scissors.service;

import com.ciklum.rock_paper_scissors.domain.GameOption;
import com.ciklum.rock_paper_scissors.domain.Result;
import com.ciklum.rock_paper_scissors.domain.Round;
import com.ciklum.rock_paper_scissors.domain.User;
import com.ciklum.rock_paper_scissors.repository.RoundRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RoundService {
    private final GameOptionGenerator player1GameOptionGenerator;
    private final GameOptionGenerator player2GameOptionGenerator;
    private final RoundRepository roundRepository;

    public Round create(User user) {
        GameOption player1GameOption = player1GameOptionGenerator.playRound();
        GameOption player2GameOption = player2GameOptionGenerator.playRound();

        return roundRepository.create(Round.builder()
                .firstPlayerOption(player1GameOption)
                .secondPlayerOption(player2GameOption)
                .user(user)
                .result(Result.winner(player1GameOption, player2GameOption)));
    }
}
