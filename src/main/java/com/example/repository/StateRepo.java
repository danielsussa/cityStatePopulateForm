package com.example.repository;

import com.example.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by daniel on 13/10/16.
 */


public interface StateRepo extends JpaRepository<State,String> {
}
