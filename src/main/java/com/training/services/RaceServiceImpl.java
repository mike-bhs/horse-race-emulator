package com.training.services;

import com.training.AppConfig;
import com.training.domain.Horse;
import com.training.domain.Race;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class RaceServiceImpl implements RaceService {
    private static final Logger log = LoggerFactory.getLogger(EmulationServiceImpl.class);

    @Override
    public Race getRace() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        List<Horse> horses = (List<Horse>) context.getBean("horses");

        return new Race(horses);
    }

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
