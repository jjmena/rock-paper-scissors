package com.ciklum.rock_paper_scissors.repository;

import com.ciklum.rock_paper_scissors.domain.User;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, String> {

    default User create() {
        User user = User.builder().userId(UUID.randomUUID().toString()).build();
        return this.save(user);
    }

    User save(User user);
    Optional<User> findByUserId(String userId);

}
