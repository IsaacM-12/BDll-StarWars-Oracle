package com.BDll.BDStarWars.DTO;

public class DTOPlace {
    private String name;
    private int temperature;
    private int sizePlace;

    public DTOPlace() {
    }

    public DTOPlace(String name, int temperature, int sizePlace) {
        this.name = name;
        this.temperature = temperature;
        this.sizePlace = sizePlace;
    }

    public String getName() {
        return name;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getSizePlace() {
        return sizePlace;
    }

    @Override
    public String toString() {
        return "DTOPlace{" +
                "name='" + name + '\'' +
                ", temperature=" + temperature +
                ", size=" + sizePlace +
                '}';
    }
}
