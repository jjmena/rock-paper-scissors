package com.ciklum.rock_paper_scissors.controller;

import com.ciklum.rock_paper_scissors.domain.Round;
import com.ciklum.rock_paper_scissors.domain.User;
import com.ciklum.rock_paper_scissors.service.RoundService;
import com.ciklum.rock_paper_scissors.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value ="/round", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Slf4j
@RestController
public class RoundController {

    @Autowired
    private final RoundService roundService;

    @Autowired
    private final UserService userService;

    @PostMapping(value = "/user/{userId}")
    public Round createRound(@PathVariable String userId) {
        log.info("[ROUND] Create round request by {} user", userId);
        // TODO: Find user to create the round
        return roundService.create(User.builder().userId(userId).build());
    }

}
