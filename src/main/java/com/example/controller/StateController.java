package com.example.controller;

import com.example.model.State;
import com.example.repository.StateRepo;
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
public class StateController {

    @Autowired
    StateRepo stateRepo;

    @RequestMapping(
            value = "/api/state",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<State>> getState(){
        List<State> stateList = stateRepo.findAll();
        return new ResponseEntity<Collection<State>>(stateList, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/state",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<State> saveProduct(@RequestBody State state)
    {
        try {
            State newState = stateRepo.save(state);
            return new ResponseEntity<State>(newState,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<State>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(
            value = "/api/state",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<State> removeCity(@RequestBody State state)
    {
        try{
            stateRepo.delete(state);
            return new ResponseEntity<State>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<State>(HttpStatus.NOT_ACCEPTABLE);
        }

    }
}
