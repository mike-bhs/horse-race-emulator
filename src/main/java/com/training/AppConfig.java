package com.training;

import com.training.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public BetServiceImpl betService() { return new BetServiceImpl(); }

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
