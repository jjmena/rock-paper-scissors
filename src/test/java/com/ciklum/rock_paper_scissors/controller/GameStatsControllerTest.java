package com.ciklum.rock_paper_scissors.controller;

import guru.nidi.ramltester.RamlDefinition;
import guru.nidi.ramltester.RamlLoaders;
import guru.nidi.ramltester.SimpleReportAggregator;
import guru.nidi.ramltester.core.RamlReport;
import guru.nidi.ramltester.junit.RamlMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GameStatsControllerTest {

    private static final RamlDefinition ramlDefinition = RamlLoaders.fromClasspath().load("api.raml");
    private static final SimpleReportAggregator aggregator = new SimpleReportAggregator();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldRetrieveGameStats() throws Exception {

        // When
        ResultActions resultActions = mockMvc.perform(get(("/stats")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.DRAW").isNumber())
                .andExpect(jsonPath("$.WINNER_PLAYER1").isNumber())
                .andExpect(jsonPath("$.WINNER_PLAYER2").isNumber());

        // Then
        RamlReport ramlReport = aggregator.addReport(ramlDefinition.testAgainst(resultActions.andReturn()));
        MatcherAssert.assertThat(ramlReport, RamlMatchers.hasNoViolations());

    }
}

