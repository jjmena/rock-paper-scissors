package com.ciklum.rock_paper_scissors.service;

import com.ciklum.rock_paper_scissors.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void shouldCreateAnUser() {
        // When
        User user = userService.create();

        // Then
        assertThat(user).isNotNull();
        assertThat(user.getUserId()).isNotNull();

    }

}
