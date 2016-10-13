package com.example.model;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by daniel on 13/10/16.
 */

@Entity
public class State {

    @Id
    @GeneratedValue
    private BigInteger id;

    @Column(unique = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getId() {
        return id;
    }
}
