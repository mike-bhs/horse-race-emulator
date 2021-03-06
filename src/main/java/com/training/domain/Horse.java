package com.training.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Horse {
    @Getter
    private final String name;
    @Getter
    private final Breed breed;
    @Getter
    private final Rider rider;
}
