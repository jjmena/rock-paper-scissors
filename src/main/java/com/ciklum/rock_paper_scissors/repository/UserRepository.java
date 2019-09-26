package com.ciklum.rock_paper_scissors.repository;

import com.ciklum.rock_paper_scissors.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {

    private static final List<User> users = new ArrayList<>();

    public User create() {
        User user = User.builder().userId(UUID.randomUUID().toString()).build();
        users.add(user);
        return user;
    }

    public Optional<User> findByUserId(String userId) {
        return users.stream().filter(u -> u.getUserId().equals(userId)).findFirst();
    }

}
