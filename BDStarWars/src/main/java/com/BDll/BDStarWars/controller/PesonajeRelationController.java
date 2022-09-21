package com.BDll.BDStarWars.controller;

import com.BDll.BDStarWars.models.PersonajeRelation;
import com.BDll.BDStarWars.repository.PersonajeRelationRepository;
import com.BDll.BDStarWars.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
//@RequestMapping(path = "/v1")
public class PesonajeRelationController {

    @Autowired
    private PersonajeRelationRepository personajeRelationRepository;

    @Autowired
    private RelationService relationService;

    // seleccionar todos
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/relation")
    public List<PersonajeRelation> getRelation() {
        return personajeRelationRepository.findAll();
    }


    // crea
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/relation")
    public void createRelation(@RequestBody PersonajeRelation newrelation){

        int id = newrelation.getIdPersonaje();
        Optional<PersonajeRelation> personajeRelation = personajeRelationRepository.findById(id);

        if(personajeRelation.isEmpty()){
            relationService.insertPersonaje(newrelation.getIdPersonaje(),newrelation.getIdPlace(),newrelation.getIdType());
        }
        else {
            throw new RuntimeException("Relacion ID personaje ocupado: " + id);
        }
    }


    // borra por Id
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(path = "/relation/{id}")
    public void deleteRelation(@PathVariable int id){
        Optional<PersonajeRelation> personajeRelation = personajeRelationRepository.findById(id);
        if(personajeRelation.isEmpty()){
            throw  new RuntimeException("Relation not found: " + id);
        }
        personajeRelationRepository.deleteById(id);
    }
}
