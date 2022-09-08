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
    private int size;

    public Place(int id, String name, int temperature, int size) {
        this.Id = id;
        this.name = name;
        this.temperature = temperature;
        this.size = size;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Place: " +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", temperature=" + temperature +
                ", size=" + size;
    }
}
