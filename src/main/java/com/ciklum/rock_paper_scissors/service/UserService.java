package com.ciklum.rock_paper_scissors.service;

import com.ciklum.rock_paper_scissors.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UserService {

    public User create() {
        return User.builder().userId(UUID.randomUUID().toString()).build();
    }
}
