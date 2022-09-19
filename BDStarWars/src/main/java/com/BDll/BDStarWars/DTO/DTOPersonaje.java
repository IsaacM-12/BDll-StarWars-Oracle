package com.BDll.BDStarWars.DTO;

public class DTOPersonaje {
    private String name;
    private int age;

    public DTOPersonaje() {
    }

    public DTOPersonaje(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
