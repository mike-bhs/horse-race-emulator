package com.training.services;

import com.training.domain.Horse;
import com.training.domain.Race;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class EmulationServiceImpl implements EmulationService {

    private static final Logger log = LoggerFactory.getLogger(EmulationServiceImpl.class);

    @Override
    public Horse emulateRace(Race race) {
        announceRace(race);

        Horse horse = pickWinner(race);

        announceWinner(horse);

        return horse;
    }

    private void announceRace(Race race) {
        log.info("=== Race begins ===");

        String horseNames = race
                .getHorses()
                .stream()
                .map(Horse::getName)
                .collect(Collectors.joining(" | "));

        log.info(horseNames);
        log.info("The race has started, all horses are pretty equal");
    }

    private void announceWinner(Horse horse) {
        String horseNameBreed = String.format("%s (%s)", horse.getName(), horse.getBreed());
        String riderName = horse.getRider().getName();

        log.info(String.format("With insignificant advantage %s with rider %s wins!!!", horseNameBreed, riderName));
    }

    private Horse pickWinner(Race race) {
        List<Horse> allHorses = race.getHorses();
        Random rand = new Random();

        return allHorses.get(rand.nextInt(allHorses.size()));
    }
}
