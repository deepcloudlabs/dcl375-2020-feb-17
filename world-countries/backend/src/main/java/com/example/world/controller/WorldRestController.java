package com.example.world.controller;

import com.example.world.dao.CountryDao;
import com.example.world.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Collection;
import java.util.Objects;

/**
 * 
 * @author Binnur Kurt (binnur.kurt@gmail.com)
 *
 */
@RestController
@RequestScope
@CrossOrigin
public class WorldRestController {

    @Autowired
    private CountryDao countryDao;

    // GET http://localhost:7070/world/api/continents
    @GetMapping("continents")
    public Collection<String> getContinents(){
        return countryDao.getAllContinents();
    }

    // GET http://localhost:7070/world/api/countries?continent=Asia
    @GetMapping(value="countries")
    public Collection<Country> getCountriesByContinent(
            @RequestParam(value="continent",required=false)
                    String continent){
        if (Objects.isNull(continent))
            return countryDao.findAllCountries();
        return countryDao.findCountriesByContinent(continent);
    }
}
