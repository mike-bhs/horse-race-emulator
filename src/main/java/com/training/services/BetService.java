package com.training.services;

import com.training.domain.Bet;
import com.training.domain.Horse;
import com.training.domain.InvalidBetTypeException;

import java.io.IOException;

public interface BetService {
    Bet readBetFromConsole() throws IOException, InvalidBetTypeException;
    boolean hasWon(Bet bet, Horse winner);
}
