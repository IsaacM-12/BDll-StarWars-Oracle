package com.BDll.BDStarWars.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PersonajeRelation {
    @Id
    private int idPersonaje;
    private int idType;
    private int idPlace;

    public PersonajeRelation() {
    }

    public PersonajeRelation(int idPersonaje, int idType, int idPlace) {
        this.idPersonaje = idPersonaje;
        this.idType = idType;
        this.idPlace = idPlace;
    }

    public int getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(int idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public int getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(int idPlace) {
        this.idPlace = idPlace;
    }
}
