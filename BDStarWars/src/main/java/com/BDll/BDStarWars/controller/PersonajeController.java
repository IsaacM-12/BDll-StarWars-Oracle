package com.BDll.BDStarWars.controller;

import com.BDll.BDStarWars.models.Personaje;
import com.BDll.BDStarWars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/v1")

public class PersonajeController {

    private final PersonajeService personajeService;

    @Autowired
    public PersonajeController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping(path = "/personajes")
    public List<Personaje> getPersonaje() {
        return personajeService.findAllPersonajes();
    }

    @GetMapping(path = "/personajes/id")
    public Personaje getById() {
        return personajeService.findByPersonajeId(1);
    }

}
