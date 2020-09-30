package com.training.services;

import com.training.domain.Race;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RaceServiceImpl implements RaceService {
    private static final Logger log = LoggerFactory.getLogger(RaceServiceImpl.class);


    @Override
    public void printRaceInfo(Race race) {
        log.info("Upcoming race participants");

        race.getHorses().forEach(horse -> {
            log.info(
                    String.format("Horse: %s, Breed: %s, Rider: %s",
                            horse.getName(),
                            horse.getBreed().toString(),
                            horse.getRider().getName())
            );
        });
    }
}
