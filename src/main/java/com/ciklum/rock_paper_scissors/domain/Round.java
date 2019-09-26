package com.ciklum.rock_paper_scissors.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Round {

    private final String roundId;
    private final GameOption firstPlayerOption;
    private final GameOption secondPlayerOption;
    private final User user;
    private final Result result;

}
