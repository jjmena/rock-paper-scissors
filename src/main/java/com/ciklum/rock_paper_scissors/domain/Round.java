package com.ciklum.rock_paper_scissors.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Round {

    private final String roundId;
    private final GameOption firstPlayerOption;
    private final GameOption secondPlayerOption;
    private final User user;
    private final Result result;

}
