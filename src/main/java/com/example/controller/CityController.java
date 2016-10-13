package com.example.controller;

import com.example.model.City;
import com.example.repository.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * Created by daniel on 13/10/16.
 */

@RestController
public class CityController {

    @Autowired
    CityRepo cityRepo;

    @RequestMapping(
            value = "/api/city",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<City>> getCity(){
        List<City> stateList = cityRepo.findAll();
        return new ResponseEntity<Collection<City>>(stateList, HttpStatus.OK);

    }

    @RequestMapping(
            value = "/api/city",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<City> saveCity(@RequestBody City city)
    {
        try {
            City newCity = cityRepo.save(city);
            return new ResponseEntity<City>(newCity,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<City>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(
            value = "/api/city",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<City> removeCity(@RequestBody City city)
    {
        cityRepo.delete(city);
        return new ResponseEntity<City>(HttpStatus.OK);
    }

}
