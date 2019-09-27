package com.ciklum.rock_paper_scissors.controller;

import lombok.Getter;

/**
 * Exception to raise when an operation was launched for a non-existing user
 */
@Getter
public class UserNotExistException extends Exception {

    private final String userId;

    public UserNotExistException(String userId) {
        super();
        this.userId  = userId;
    }
}
