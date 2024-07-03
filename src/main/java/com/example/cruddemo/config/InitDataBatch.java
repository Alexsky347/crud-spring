package com.example.cruddemo.config;

import com.example.cruddemo.models.Beer;
import com.example.cruddemo.repository.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitDataBatch {

    @Bean
    CommandLineRunner initDatabase(BeerRepository repository) {
        return args -> {
            if((long) repository.findAll().size() == 0) {
                for (int i = 0; i < 500; i++) {
                    Beer beer = new Beer();
                    beer.setName("Beer" + i);
                    beer.setTagline("Tagline" + i);
                    beer.setFirst_brewed("First Brewed" + i);
                    beer.setDescription("Description" + i);
                    beer.setImage_url("Image URL" + i);
                    beer.setAbv(5);
                    beer.setIbu(10);
                    beer.setTarget_fg(15);
                    beer.setTarget_og(20);
                    beer.setEbc(25);
                    beer.setSrm(30);
                    beer.setPh(35);
                    beer.setAttenuation_level(40);
                    beer.setVolume("Volume" + i);
                    beer.setBoil_volume("Boil Volume" + i);
                    beer.setMethod("Method" + i);
                    beer.setIngredients("Ingredients" + i);
                    beer.setFood_pairing("Food Pairing" + i);
                    beer.setBrewers_tips("Brewers Tips" + i);
                    beer.setContributed_by("Contributed By" + i);
                    repository.save(beer);
                }
            }
        };
    }
}