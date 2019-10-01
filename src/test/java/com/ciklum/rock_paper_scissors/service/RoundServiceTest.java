package com.ciklum.rock_paper_scissors.service;

import com.ciklum.rock_paper_scissors.domain.Round;
import com.ciklum.rock_paper_scissors.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static com.ciklum.rock_paper_scissors.domain.GameOption.ROCK;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RoundServiceTest {

    @Autowired
    private RoundService roundService;

    @Autowired
    private UserService userService;

    @Test
    public void shouldCreateARound() {
        // Given
        User user = userService.create();

        // When
        Round round = roundService.create(user);

        // Then
        assertThat(round).isNotNull();
        assertThat(round.getRoundId()).isNotNull();
        assertThat(round.getFirstPlayerOption()).isEqualTo(ROCK);
        assertThat(round.getFirstPlayerOption()).isNotNull();
        assertThat(round.getUser()).isEqualTo(user);
        assertThat(round.getResult()).isNotNull();

    }

    @Test
    public void shouldRemoveRoundsByUser() {
        // Given
        User user = userService.create();
        Round round = roundService.create(user);

        // When
        roundService.delete(user);

        // Then
        Optional<Round> roundStored = roundService.findById(round.getRoundId());
        assertThat(roundStored.isPresent()).isFalse();
    }

}
