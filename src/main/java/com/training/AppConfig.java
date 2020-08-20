package com.training;

import com.training.domain.Breed;
import com.training.domain.Horse;
import com.training.domain.Rider;
import com.training.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean(name = "horses")
    public List<Horse> horses() {
        return Arrays.asList(
                new Horse("Lightning", Breed.ARABIAN, new Rider("John")),
                new Horse("King", Breed.MORGAN, new Rider("Andrew")),
                new Horse("Spark", Breed.MORGAN, new Rider("Adam")),
                new Horse("Lucky", Breed.STANDARDBRED, new Rider("Bruce")),
                new Horse("Spike", Breed.QUARTER, new Rider("George")),
                new Horse("Thunder", Breed.ARABIAN, new Rider("Thomas")),
                new Horse("Storm", Breed.QUARTER, new Rider("James"))
        );
    }

    @Bean
    public RaceServiceImpl raceService() {
        return new RaceServiceImpl();
    }

    @Bean
    public HorseServiceImp horseService() {
        return new HorseServiceImp();
    }

    @Bean
    public EmulationServiceImpl emulationService() {
        return new EmulationServiceImpl();
    }
}
