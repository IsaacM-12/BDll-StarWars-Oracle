package com.BDll.BDStarWars.repository;

import com.BDll.BDStarWars.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place,Integer> {
}
