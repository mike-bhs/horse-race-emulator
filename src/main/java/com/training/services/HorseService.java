package com.training.services;

import com.training.domain.Horse;

import java.io.FileNotFoundException;
import java.util.List;

public interface HorseService {
    List<Horse> readHorses(String horsesFilePath) throws FileNotFoundException;
}
