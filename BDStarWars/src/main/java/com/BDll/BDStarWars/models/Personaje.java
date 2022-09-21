package com.BDll.BDStarWars.models;

import org.springframework.data.annotation.Reference;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Personaje {
    @Id
    //@GeneratedValue
    private int id;
    private String name;
    private String gender;
    private int height;
    private int age;

    public Personaje() {
    }

    public Personaje(int id, String name, String gender, int height, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.height = height;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
