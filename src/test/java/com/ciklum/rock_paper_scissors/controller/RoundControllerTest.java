package com.ciklum.rock_paper_scissors.controller;

import com.ciklum.rock_paper_scissors.domain.Round;
import com.ciklum.rock_paper_scissors.domain.User;
import com.ciklum.rock_paper_scissors.service.RoundService;
import com.ciklum.rock_paper_scissors.service.UserService;
import guru.nidi.ramltester.RamlDefinition;
import guru.nidi.ramltester.RamlLoaders;
import guru.nidi.ramltester.SimpleReportAggregator;
import guru.nidi.ramltester.core.RamlReport;
import guru.nidi.ramltester.junit.RamlMatchers;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RoundControllerTest {

    private static final RamlDefinition ramlDefinition = RamlLoaders.fromClasspath().load("api.raml");
    private static final SimpleReportAggregator aggregator = new SimpleReportAggregator();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Autowired
    private RoundService roundService;

    @Test
    public void shouldCreateRoundForExistingUser() throws Exception {

        // Given
        User user = userService.create();

        // When
        ResultActions resultActions = mockMvc.perform(post(("/round/user/" + user.getUserId())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.roundId").isNotEmpty())
                .andExpect(jsonPath("$.firstPlayerOption").value("ROCK"))
                .andExpect(jsonPath("$.secondPlayerOption").isNotEmpty())
                .andExpect(jsonPath("$.user.userId").value(user.getUserId()))
                .andExpect(jsonPath("$.result").isNotEmpty());

        // Then
        RamlReport ramlReport = aggregator.addReport(ramlDefinition.testAgainst(resultActions.andReturn()));
        assertThat(ramlReport, RamlMatchers.hasNoViolations());

        // TODO: Pending to add Spring Rest Docs

    }

    @Test
    public void shouldFailCreateRoundForNotExistingUser() throws Exception {

        // Given
        String userId = UUID.randomUUID().toString();

        // When
        ResultActions resultActions = mockMvc.perform(post(("/round/user/" + userId)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.reason").value(Matchers.equalTo(String.format("User %s doesn't exist", userId))));

        // Then
        RamlReport ramlReport = aggregator.addReport(ramlDefinition.testAgainst(resultActions.andReturn()));
        assertThat(ramlReport, RamlMatchers.hasNoViolations());
    }

    @Test
    public void shouldRemoveExistingRoundsForAnUser() throws Exception {
        // Given
        User user = userService.create();
        Round round = roundService.create(user);

        // When
        ResultActions resultActions = mockMvc.perform(delete(("/round/user/" + user.getUserId())))
                .andExpect(status().isOk());

        // Then
        RamlReport ramlReport = aggregator.addReport(ramlDefinition.testAgainst(resultActions.andReturn()));
        assertThat(ramlReport, RamlMatchers.hasNoViolations());
        Optional<Round> roundStored = roundService.findById(round.getRoundId());
        assertThat(roundStored.isPresent(), is(false));

    }

    @Test
    public void shouldFailDeleteRoundsForNotExistingUser() throws Exception {

        // Given
        String userId = UUID.randomUUID().toString();

        // When
        ResultActions resultActions = mockMvc.perform(delete(("/round/user/" + userId)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.reason").value(Matchers.equalTo(String.format("User %s doesn't exist", userId))));

        // Then
        RamlReport ramlReport = aggregator.addReport(ramlDefinition.testAgainst(resultActions.andReturn()));
        assertThat(ramlReport, RamlMatchers.hasNoViolations());
    }

}
