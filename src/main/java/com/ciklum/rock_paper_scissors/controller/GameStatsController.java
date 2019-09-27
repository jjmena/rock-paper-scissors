package com.ciklum.rock_paper_scissors.controller;

import com.ciklum.rock_paper_scissors.domain.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping(value = "/stats")
@RequiredArgsConstructor
@Slf4j
@RestController
@CrossOrigin(origins = {"${application.cors.origins}"})
public class GameStatsController {

    @GetMapping
    public Map<Result, Integer> stats()  {
        return Result.stats();
    }
}
