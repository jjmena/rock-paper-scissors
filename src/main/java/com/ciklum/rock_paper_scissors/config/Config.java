package com.ciklum.rock_paper_scissors.config;

import com.ciklum.rock_paper_scissors.domain.GameOption;
import com.ciklum.rock_paper_scissors.repository.RoundRepository;
import com.ciklum.rock_paper_scissors.repository.UserRepository;
import com.ciklum.rock_paper_scissors.service.RoundService;
import com.ciklum.rock_paper_scissors.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.ciklum.rock_paper_scissors.domain.GameOption.ROCK;

@Configuration
public class Config {

    @Bean
    public RoundService roundService(RoundRepository roundRepository) {
        return new RoundService(() -> ROCK, GameOption::randomOption, roundRepository);
    }

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }

}
