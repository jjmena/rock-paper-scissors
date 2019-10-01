package com.ciklum.rock_paper_scissors.repository;

import com.ciklum.rock_paper_scissors.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    private static final Map<String, User> users = new ConcurrentHashMap<>();

    public User create() {
        User user = User.builder().userId(UUID.randomUUID().toString()).build();
        users.put(user.getUserId(), user);
        return user;
    }

    public Optional<User> findByUserId(String userId) {
        return Optional.ofNullable(users.get(userId));
    }

}
