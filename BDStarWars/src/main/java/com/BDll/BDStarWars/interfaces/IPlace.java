package com.BDll.BDStarWars.interfaces;


import com.BDll.BDStarWars.models.Place;

import java.util.List;

public interface IPlace {
    public List<Place> findAllPlace();
    public Place findByPlaceId(int id);
    public void deletePlace(int id);
    public void updatePlace(Place place);
    public void insertPlace(Place place);
}
