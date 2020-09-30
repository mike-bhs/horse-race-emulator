package com.training.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Bet {
    @Getter
    private final String value;
    @Getter
    private final BetType type;
}
