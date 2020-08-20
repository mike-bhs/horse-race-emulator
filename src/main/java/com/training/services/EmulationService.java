package com.training.services;

import com.training.domain.Horse;
import com.training.domain.Race;

public interface EmulationService {
    Horse emulateRace(Race race);
}
