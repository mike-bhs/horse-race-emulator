package com.training.services;

import com.training.domain.Breed;
import com.training.domain.Horse;
import com.training.domain.Rider;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HorseServiceImp implements HorseService {

    @Override
    public List<Horse> readHorses(String horsesFilePath) throws FileNotFoundException {
        Yaml yaml = new Yaml();
        InputStream inputStream = new FileInputStream(new File(horsesFilePath));
        Map<String, Object> document = yaml.load(inputStream);
        List<Map<String, Object>> horses = (List<Map<String, Object>>) document.get("horses");

        return horses.stream().map(horseInfo -> {
            Map<String, String> riderInfo = (Map<String, String>) horseInfo.get("rider");
            Rider rider = new Rider(riderInfo.get("name"));
            String horseName = (String) horseInfo.get("name");
            String breedName = (String) horseInfo.get("breed");
            Breed breed = Breed.valueOf(breedName.toUpperCase());

            return new Horse(horseName, breed, rider);
        }).collect(Collectors.toList());
    }
}
