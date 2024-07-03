package com.example.cruddemo.services;

import com.example.cruddemo.models.Beer;
import com.example.cruddemo.repository.BeerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BeerService {
    private final BeerRepository beerRepository;

    BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public List<Beer> findAll(String beerName) {
        if (beerName != null){
           return  this.beerRepository.findAllByNameContains(beerName);
        }
       return beerRepository.findAll();
    }

    public void createBeer(Beer beer){
        beerRepository.save(beer);
    }

    public void deleteBeer(Long id){
        beerRepository.deleteById(id);
    }

    public void updateBeer(Long id, Beer beer){
        beerRepository.findById(id).ifPresentOrElse(
                beer1 -> {
                    beer1.setName(beer.getName());
                    beerRepository.save(beer1);
                },
                () -> {
                    throw new RuntimeException("Beer not found");
                });
    }
}
