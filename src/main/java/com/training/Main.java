package com.training;

import com.training.domain.Bet;
import com.training.domain.Horse;
import com.training.domain.InvalidBetTypeException;
import com.training.domain.Race;
import com.training.services.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HorseService horseService = context.getBean(HorseServiceImp.class);

        List<Horse> horses;
        try {
            horses = horseService.readHorses("src/main/resources/horses.yml");
        } catch(FileNotFoundException e) {
            log.error(String.format("Horses file not found: %s", e.getMessage()));
            return;
        }

        Race race = new Race(horses);
        printRaceInfo(context, race);

        BetService betService = context.getBean(BetServiceImpl.class);
        Bet bet;
        try {
            bet = betService.readBetFromConsole();
        } catch(IOException e) {
            log.error(String.format("Failed to read your bet: %s", e.getMessage()));
            return;
        } catch(InvalidBetTypeException e) {
            log.error(e.getMessage());
            return;
        }

        Horse winner = startRace(context, race);
        checkBet(betService, bet, winner);
    }

    private static void printRaceInfo(ApplicationContext context, Race race) {
        RaceService raceService = context.getBean(RaceServiceImpl.class);
        raceService.printRaceInfo(race);
    }

    private static Horse startRace(ApplicationContext context, Race race) {
        EmulationService emulationService = context.getBean(EmulationServiceImpl.class);
        return emulationService.emulateRace(race);
    }

    private static void checkBet(BetService betService, Bet bet, Horse winner) {
        if (betService.hasWon(bet, winner)) {
            log.info("Congrats you won!");
        } else {
            log.info("Better luck next time!");
        }
    }
}
