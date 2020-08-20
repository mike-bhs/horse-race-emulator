package com.training.domain;

import lombok.Getter;

public class Horse {
    @Getter
    private final String name;
    @Getter
    private final Breed breed;
    @Getter
    private final Rider rider;

    public Horse(String name, Breed breed, Rider rider) {
        this.name = name;
        this.breed = breed;
        this.rider = rider;
    }
}
