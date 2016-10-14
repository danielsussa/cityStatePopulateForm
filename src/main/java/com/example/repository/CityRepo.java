package com.example.repository;

import com.example.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by daniel on 13/10/16.
 */
public interface CityRepo extends JpaRepository<City,String>{
    public  List<City> findByStateId(BigInteger id);
}
