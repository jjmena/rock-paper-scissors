package com.ciklum.rock_paper_scissors.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Getter
public class User {
    private final String userId;
}
