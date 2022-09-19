package com.BDll.BDStarWars.DTO;

public class DTOType {
    private String name;
    private String skin;

    public DTOType() {
    }

    public DTOType(String name, String skin) {
        this.name = name;
        this.skin = skin;
    }

    public String getName() {
        return name;
    }

    public String getSkin() {
        return skin;
    }
}
