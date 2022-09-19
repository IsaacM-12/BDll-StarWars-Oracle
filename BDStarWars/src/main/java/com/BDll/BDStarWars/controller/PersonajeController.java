package com.BDll.BDStarWars.controller;

import com.BDll.BDStarWars.DTO.DTOPersonaje;
import com.BDll.BDStarWars.models.Personaje;
import com.BDll.BDStarWars.repository.PersonajeRepository;

import com.BDll.BDStarWars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping(path = "/v1")

public class PersonajeController {

    @Autowired
    private PersonajeRepository personajeRepository;

    @Autowired // este no
    private PersonajeService personajeService;


    // seleccionar todos
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/personajes")
    public List<Personaje> getPersonajes() {
        return personajeRepository.findAll();
    }


    // seleccionar por id
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/personajes/{id}")
    public Personaje getById(@PathVariable int id) {
        Optional<Personaje> personaje = personajeRepository.findById(id);

        if(personaje.isEmpty()){
            throw new RuntimeException("personaje not found: " + id);
        }
        return personaje.get();
    }


    // crea
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/personajes")
    public void createPersonaje(@RequestBody Personaje newpersonaje){
        int id = newpersonaje.getId();
        Optional<Personaje> personaje = personajeRepository.findById(id);

        if(personaje.isEmpty()){
            personajeRepository.save(newpersonaje);
        }
        else {
            throw new RuntimeException("Personaje ID ocupado: " + id);
        }
    }


    // actualiza por Id
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(path = "/personajes/{id}")
    public void updatePersonaje(@PathVariable int id,@RequestBody DTOPersonaje newpersonaje){
        Optional<Personaje> personaje = personajeRepository.findById(id);
        if(personaje.isEmpty()){
            throw new RuntimeException("personaje not found: " + id);
        }
        personaje.get().setAge(newpersonaje.getAge());
        personaje.get().setName(newpersonaje.getName());

        personajeRepository.save(personaje.get());
    }


    // borra por Id
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(path = "/personajes/{id}")
    public void deletePersonaje(@PathVariable int id){
        Optional<Personaje> personaje = personajeRepository.findById(id);
        if(personaje.isEmpty()){
            throw  new RuntimeException("personaje not found: " + id);
        }
        personajeRepository.deleteById(id);
    }






    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/personajesaMano")
    public List<Personaje> getPersonajesAMano() {
        return personajeService.findAllPersonajes();
    }
}