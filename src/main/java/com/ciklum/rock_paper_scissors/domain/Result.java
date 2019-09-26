package com.ciklum.rock_paper_scissors.domain;

public enum Result {
    WINNER_PLAYER1, WINNER_PLAYER2, DRAW;

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
}
