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
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/place/{id}")
    public Place getById(@PathVariable int id) {
        Optional<Place> place = placeRepository.findById(id);

        if(place.isEmpty()){
            throw new RuntimeException("place not found: " + id);
        }
        return place.get();
    }


    // crea
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/place")
    public void createPLace(@RequestBody Place newplace){
        int id = newplace.getId();
        Optional<Place> place = placeRepository.findById(id);
        if(place.isEmpty()){
            placeRepository.save(newplace);
        }
        else {
            throw new RuntimeException("Place ID ocupado: " + id);
        }
    }


    // actualiza por Id
    @CrossOrigin(origins = "http://localhost:3000")
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
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(path = "/place/{id}")
    public void deletePLace(@PathVariable int id){
        Optional<Place> place = placeRepository.findById(id);
        if(place.isEmpty()){
            throw  new RuntimeException("personaje not found: " + id);
        }
        placeRepository.deleteById(id);
    }

}
