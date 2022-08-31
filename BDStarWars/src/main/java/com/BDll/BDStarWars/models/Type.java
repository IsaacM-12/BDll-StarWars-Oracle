package com.BDll.BDStarWars.models;

public class Type {
    private int Id;
    private String name;
    private String skin;

    public Type(int id, String name, String skin) {
        this.Id = id;
        this.name = name;
        this.skin = skin;
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

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    @Override
    public String toString() {
        return "Type: " +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", skin='" + skin;
    }
}
