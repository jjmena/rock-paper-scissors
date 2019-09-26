package com.ciklum.rock_paper_scissors.service;

import com.ciklum.rock_paper_scissors.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UserService {

    public User create() {
        // TODO: Save user
        return User.builder().userId(UUID.randomUUID().toString()).build();
    }

    public User findUserById() {
        return null;
    }

}
