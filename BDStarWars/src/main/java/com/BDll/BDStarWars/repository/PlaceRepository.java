package com.BDll.BDStarWars.repository;

import com.BDll.BDStarWars.models.Personaje;
import com.BDll.BDStarWars.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Personaje,Integer> {
}
