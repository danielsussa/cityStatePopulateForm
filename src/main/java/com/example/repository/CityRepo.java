package com.example.repository;

import com.example.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by daniel on 13/10/16.
 */
public interface CityRepo extends JpaRepository<City,String>{
}
