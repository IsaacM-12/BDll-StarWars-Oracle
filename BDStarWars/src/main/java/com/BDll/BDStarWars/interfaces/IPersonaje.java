package com.BDll.BDStarWars.interfaces;

import com.BDll.BDStarWars.models.Personaje;

import java.util.List;

public interface IPersonaje {
    public List<Personaje> findAllPersonajes();
    public Personaje findByPersonajeId(int id);
    public void deletePersonaje(int id);
    public void updatePersonaje(Personaje personaje);
    public void insertPersonaje(Personaje personaje);
}
