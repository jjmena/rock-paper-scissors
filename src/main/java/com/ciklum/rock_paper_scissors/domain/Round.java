package com.ciklum.rock_paper_scissors.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Round {

    @Id
    private String roundId;
    private GameOption firstPlayerOption;
    private GameOption secondPlayerOption;
    @ManyToOne
    private User user;
    private Result result;

}
