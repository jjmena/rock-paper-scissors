package com.ciklum.rock_paper_scissors.domain;

import java.util.Random;

public enum GameOption {
    ROCK, PAPER, SCISSORS;

    private static final Random random = new Random();

    public static GameOption randomOption() {
        return GameOption.values()[random.nextInt(GameOption.values().length)];
    }
}
