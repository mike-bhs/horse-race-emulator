package com.training.services;

import com.training.domain.Horse;

public interface HorseService {
    boolean checkBetMatch(Horse horse, String bet);
}
