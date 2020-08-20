package com.training.domain;

import lombok.Getter;

import java.util.List;

public class Race {
    @Getter
    private final List<Horse> horses;

    public Race(List<Horse> horses) {
        this.horses = horses;
    }
}
