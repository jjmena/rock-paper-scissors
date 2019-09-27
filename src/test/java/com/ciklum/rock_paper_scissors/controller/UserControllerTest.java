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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    private static final RamlDefinition ramlDefinition = RamlLoaders.fromClasspath().load("api.raml");
    private static final SimpleReportAggregator aggregator = new SimpleReportAggregator();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createUser() throws Exception {

        // When
        ResultActions resultActions = mockMvc.perform(post(("/user")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.userId").isNotEmpty());

        // Then
        RamlReport ramlReport = aggregator.addReport(ramlDefinition.testAgainst(resultActions.andReturn()));
        MatcherAssert.assertThat(ramlReport, RamlMatchers.hasNoViolations());

        // TODO: Pending to add Spring Rest Docs
    }
}

