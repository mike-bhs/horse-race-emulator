package com.training.services;

import com.training.domain.Horse;

public class HorseServiceImp implements HorseService{
    @Override
    public boolean checkBetMatch(Horse horse, String bet) {
        bet = bet.trim().toLowerCase();

        return horse.getName().toLowerCase().equals(bet) ||
                horse.getRider().getName().toLowerCase().equals(bet) ||
                horse.getBreed().toString().toLowerCase().equals(bet);
    }
}
