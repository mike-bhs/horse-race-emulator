package com.training.domain;

import lombok.Getter;

public class Rider {
    @Getter
    private final String name;

    public Rider(String name) {
        this.name = name;
    }
}
