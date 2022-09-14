package com.BDll.BDStarWars.controller;

import com.BDll.BDStarWars.DTO.DTOPersonaje;
import com.BDll.BDStarWars.models.Personaje;
import com.BDll.BDStarWars.repository.PersonajeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping(path = "/v1")

public class PersonajeController {

    @Autowired
    private PersonajeRepository personajeRepository;

//    private final PersonajeService personajeService;
//
//    @Autowired
//    public PersonajeController(PersonajeService personajeService) {
//        this.personajeService = personajeService;
//    }

    // seleccionar todos
    @GetMapping(path = "/personajes")
    public List<Personaje> getPersonajes() {
        return personajeRepository.findAll();
    }

    // seleccionar por id
    @GetMapping(path = "/personajes/{id}")
    public Personaje getById(@PathVariable int id) {
        Optional<Personaje> personaje = personajeRepository.findById(id);

        if(personaje.isEmpty()){
            throw new RuntimeException("personaje not found " + id);
        }
        return personaje.get();
    }

    // crea
    @PostMapping(path = "/personajes")
    public void createPersonaje(@RequestBody DTOPersonaje newpersonaje){
        Personaje personaje = new Personaje(1000,newpersonaje.getName(),newpersonaje.getAge());
        personajeRepository.save(personaje);
    }

    // actualiza por Id
    @PutMapping(path = "/personajes/{id}")
    public void updatePersonaje(@PathVariable int id,@RequestBody DTOPersonaje newpersonaje){
        Optional<Personaje> personaje = personajeRepository.findById(id);
        if(personaje.isEmpty()){
            throw new RuntimeException("personaje not found " + id);
        }
        personaje.get().setAge(newpersonaje.getAge());
        personaje.get().setName(newpersonaje.getName());

        personajeRepository.save(personaje.get());
    }

    // borra por Id
    @DeleteMapping(path = "/personajes/{id}")
    public void deletePersonaje(@PathVariable int id){
        Optional<Personaje> personaje = personajeRepository.findById(id);
        if(personaje.isEmpty()){
            throw  new RuntimeException("Ese curso no existe: " + id);
        }
        personajeRepository.deleteById(id);
    }
}