package com.training;

import com.training.domain.Horse;
import com.training.domain.Race;
import com.training.services.EmulationService;
import com.training.services.EmulationServiceImpl;
import com.training.services.RaceService;
import com.training.services.RaceServiceImpl;
import com.training.services.HorseService;
import com.training.services.HorseServiceImp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Race upcomingRace = announceUpcomingRace(context);
        String bet;

        try {
            bet = readBetFromConsole();
        } catch (IOException e) {
            log.error(String.format("Failed to read your bet: %s", e.getMessage()));
            return;
        }

        Horse horseWinner = emulateRace(context, upcomingRace);
        checkBet(context, horseWinner, bet);
    }

    private static String readBetFromConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter horse name, breed or rider's name to make a bet:");

        return reader.readLine().trim().toLowerCase();
    }

    private static Race announceUpcomingRace(ApplicationContext context) {
        RaceService raceService = context.getBean(RaceServiceImpl.class);
        Race upcomingRace = raceService.getRace();
        raceService.printRaceInfo(upcomingRace);

        return upcomingRace;
    }

    private static Horse emulateRace(ApplicationContext context, Race race) {
        EmulationService emulationService = context.getBean(EmulationServiceImpl.class);
        return emulationService.emulateRace(race);
    }

    private static void checkBet(ApplicationContext context, Horse winner, String bet) {
        HorseService horseService = context.getBean(HorseServiceImp.class);

        if (horseService.checkBetMatch(winner, bet)) {
            log.info("Congrats you won!");
        } else {
            log.info("Better luck next time!");
        }
    }
}
