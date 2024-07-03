package com.example.cruddemo.controllers;

import com.example.cruddemo.models.Beer;
import com.example.cruddemo.services.BeerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("BeerController")
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class BeerController {

    private final BeerService beerService;

    BeerController(BeerService beerService){
        this.beerService = beerService;
    }

    @GetMapping("/beers")
    public List<Beer> getBeers(@RequestParam(required = false) String beerName){
        return beerService.findAll(beerName);
    }

    @PostMapping("/beers")
    public void createBeer(@RequestBody Beer beer){
        beerService.createBeer(beer);
    }

    @DeleteMapping("/beers/{id}")
    public void deleteBeer(@PathVariable Long id){
        beerService.deleteBeer(id);
    }

    @PutMapping("/beers/{id}")
    public void updateBeer(@PathVariable Long id, @RequestBody Beer beer){
        beerService.updateBeer(id, beer);
    }

}
