package com.BDll.BDStarWars.repository;

import com.BDll.BDStarWars.models.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonajeRepository extends JpaRepository<Personaje,Integer> {
}
