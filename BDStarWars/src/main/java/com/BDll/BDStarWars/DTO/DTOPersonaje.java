package com.BDll.BDStarWars.DTO;

public class DTOPersonaje {
    private String name;
    private String gender;
    private int height;
    private int age;

    public DTOPersonaje() {
    }

    public DTOPersonaje(String name, String gender, int heigt, int age) {
        this.name = name;
        this.gender = gender;
        this.height = heigt;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
