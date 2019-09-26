package com.ciklum.rock_paper_scissors.config;

import com.ciklum.rock_paper_scissors.domain.GameOption;
import com.ciklum.rock_paper_scissors.service.RoundService;
import com.ciklum.rock_paper_scissors.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public RoundService roundService() {
        return new RoundService(() -> GameOption.ROCK, () -> GameOption.PAPER);
    }

    @Bean
    public UserService userService() {
        return new UserService();
    }
}
