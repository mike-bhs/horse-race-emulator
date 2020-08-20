package com.training.domain;

import lombok.Getter;

public enum Breed {
    ARABIAN("arabian"),
    STANDARDBRED("standardbred"),
    MORGAN("morgan"),
    QUARTER("quarter");

    @Getter
    public final String name;

    Breed(String name) {
        this.name = name;
    }
}
