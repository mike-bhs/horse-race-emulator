package com.training.services;

import com.training.domain.Race;

public interface RaceService {
    Race getRace();

    void printRaceInfo(Race race);
}
