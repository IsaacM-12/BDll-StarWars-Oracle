package com.BDll.BDStarWars.controller;

import com.BDll.BDStarWars.DTO.DTOPlace;
import com.BDll.BDStarWars.models.Place;
import com.BDll.BDStarWars.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping(path = "/place")
public class PlaceController {

    @Autowired
    private PlaceRepository placeRepository;


    // seleccionar todos
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/place")
    public List<Place> getPLaces() {
        return placeRepository.findAll();
    }


    // seleccionar por id
    @GetMapping(path = "/place/{id}")
    public Place getById(@PathVariable int id) {
        Optional<Place> place = placeRepository.findById(id);

        if(place.isEmpty()){
            throw new RuntimeException("place not found: " + id);
        }
        return place.get();
    }


    // crea
    @PostMapping(path = "/place")
    public void createPLace(@RequestBody DTOPlace newplace){
        Place place = new Place(1000, newplace.getName(), newplace.getTemperature(), newplace.getSizePlace()); // no se no se
        placeRepository.save(place);
    }


    // actualiza por Id
    @PutMapping(path = "/place/{id}")
    public void updatePLace(@PathVariable int id,@RequestBody DTOPlace newplace){
        Optional<Place> place = placeRepository.findById(id);
        if(place.isEmpty()){
            throw new RuntimeException("place not found: " + id);
        }
        place.get().setName(newplace.getName());
        place.get().setTemperature(newplace.getTemperature());
        place.get().setSizePlace(newplace.getSizePlace());

        placeRepository.save(place.get());
    }


    // borra por Id
    @DeleteMapping(path = "/place/{id}")
    public void deletePLace(@PathVariable int id){
        Optional<Place> place = placeRepository.findById(id);
        if(place.isEmpty()){
            throw  new RuntimeException("personaje not found: " + id);
        }
        placeRepository.deleteById(id);
    }

}
