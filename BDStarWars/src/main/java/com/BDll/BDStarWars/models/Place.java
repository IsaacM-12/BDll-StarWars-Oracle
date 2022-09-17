package com.BDll.BDStarWars.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Place {
    @Id
    @GeneratedValue
    private int Id;
    private String name;
    private int temperature;
    private int sizePlace;

    public Place() {
    }

    public Place(int id, String name, int temperature, int sizePlace) {
        super();
        this.Id = id;
        this.name = name;
        this.temperature = temperature;
        this.sizePlace = sizePlace;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getSizePlace() {
        return sizePlace;
    }

    public void setSizePlace(int sizePlace) {
        this.sizePlace = sizePlace;
    }

    @Override
    public String toString() {
        return "Place: " +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", temperature=" + temperature +
                ", size=" + sizePlace;
    }
}
