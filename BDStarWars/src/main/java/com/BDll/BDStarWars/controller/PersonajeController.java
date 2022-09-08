package com.BDll.BDStarWars.controller;

import com.BDll.BDStarWars.models.Personaje;
import com.BDll.BDStarWars.repository.PersonajeRepository;
import com.BDll.BDStarWars.service.PersonajeService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping(path = "/v1")

public class PersonajeController {

    @Autowired
    private PersonajeRepository personajeRepository;

    private final PersonajeService personajeService;

    @Autowired
    public PersonajeController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping(path = "/personajes")
    public List<Personaje> getPersonaje() {
        return personajeRepository.findAll();
    }


    @GetMapping(path = "/personajes/{id}")
    public Personaje getById(@PathVariable int id) {
        Optional<Personaje> personaje = personajeRepository.findById(id);

        if(personaje.isEmpty()){
            throw new RuntimeException("personaje not found " + id);
        }
        return personaje.get();
    }

    @PostMapping(path = "/personajes")
    public void createPersonaje(@RequestBody Personaje personaje){  // 415 Unsupported Media Type
        personajeRepository.save(personaje);
    }

    @DeleteMapping(path = "/personajes/{id}")
    public void deleteCourse(@PathVariable int id){
        Optional<Personaje> personaje = personajeRepository.findById(id);
        if(personaje.isEmpty()){
            throw  new RuntimeException("Ese curso no existe: " + id);
        }
        personajeRepository.deleteById(id);
    }
}
