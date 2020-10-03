package com.training.services;

import com.training.domain.Bet;
import com.training.domain.BetType;
import com.training.domain.Horse;
import com.training.domain.InvalidBetTypeException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BetServiceImpl implements BetService {

    @Override
    public Bet readBetFromConsole() throws IOException, InvalidBetTypeException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Would you like to put a bet on rider, horse or breed? ");
        String betTypeStr = reader.readLine().trim();

        BetType betType;
        try {
            betType = BetType.valueOf(betTypeStr.toUpperCase());
        } catch(IllegalArgumentException e) {
            throw new InvalidBetTypeException(String.format("Impossible to place bet on %s", betTypeStr));
        }

        System.out.printf("Enter the name of %s: ", betType.toString());
        String betValue = reader.readLine().trim();

        return new Bet(betValue, betType);
    }

    @Override
    public boolean hasWon(Bet bet, Horse winner) {
        boolean result = false;

        switch(bet.getType()) {
            case BREED:
                if (bet.getValue().equalsIgnoreCase(winner.getBreed().toString())) {
                    result = true;
                }
                break;
            case HORSE:
                if (bet.getValue().equalsIgnoreCase(winner.getName())) {
                    result = true;
                }
                break;
            case RIDER:
                if (bet.getValue().equalsIgnoreCase(winner.getRider().getName())) {
                    result = true;
                }
                break;
            default:
                break;
        }

        return result;
    }
}
