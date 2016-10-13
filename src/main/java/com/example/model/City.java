package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

/**
 * Created by daniel on 13/10/16.
 */

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;


    @Column(unique = true)
    private String name;

    @OneToOne
    @JoinColumn(name = "state")
    @NotNull
    private State state;

    public String getName() {
        return name;
    }

    public void setName(String city) {
        this.name = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }
}
