package com.ciklum.rock_paper_scissors.service;

import com.ciklum.rock_paper_scissors.domain.User;
import com.ciklum.rock_paper_scissors.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User create() {
        return userRepository.create();
    }

    public Optional<User> findUserById(String userId) {
        return userRepository.findByUserId(userId);
    }

}
