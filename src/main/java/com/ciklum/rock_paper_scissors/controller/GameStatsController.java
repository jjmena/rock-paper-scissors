package com.ciklum.rock_paper_scissors.controller;

import com.ciklum.rock_paper_scissors.domain.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RequestMapping(value = "/round")
@RequiredArgsConstructor
@Slf4j
@RestController
@CrossOrigin(origins = {"${application.cors.origins}"})
public class GameStatsController {

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping(value = "/stats", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Map<Result, Integer>> stats()  {
        return Mono.just(Result.stats());
    }
}
