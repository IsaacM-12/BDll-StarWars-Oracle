package com.BDll.BDStarWars.controller;

import com.BDll.BDStarWars.models.Personaje;
import com.BDll.BDStarWars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping(path = "/place")
public class PlaceController {

    private final PersonajeService personajeService;

    @Autowired
    public PlaceController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    // seleccionar todos
    @GetMapping(path = "/personajesprueba")
    public List<Personaje> getPersonajes() {
        return personajeService.findAllPersonajes();
    }

}
