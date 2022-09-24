package com.BDll.BDStarWars.controller;


import com.BDll.BDStarWars.DTO.DTOType;
import com.BDll.BDStarWars.models.Type;
import com.BDll.BDStarWars.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping(path = "/v1")

public class TypeController {

    @Autowired
    private TypeRepository typeRepository;

    // seleccionar todos
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/type")
    public List<Type> getTypes() {
        return typeRepository.findAll();
    }


    // seleccionar por id
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/type/{id}")
    public Type getById(@PathVariable int id) {
        Optional<Type> type = typeRepository.findById(id);

        if(type.isEmpty()){
            throw new RuntimeException("Type not found: " + id);
        }
        return type.get();
    }


    // crea
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/type")
    public void createType(@RequestBody Type newtype){
        int id = newtype.getId();
        Optional<Type> type = typeRepository.findById(id);
        if(type.isEmpty()){
            typeRepository.save(newtype);
        }
        else {
            throw new RuntimeException("Type ID ocupado: " + id);
        }
    }


    // actualiza por Id
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(path = "/type/{id}")
    public void updateType(@PathVariable int id,@RequestBody DTOType newtype){
        Optional<Type> type = typeRepository.findById(id);
        if(type.isEmpty()){
            throw new RuntimeException("Type not found: " + id);
        }
        type.get().setName(newtype.getName());
        type.get().setSkin(newtype.getSkin());

        typeRepository.save(type.get());
    }


    // borra por Id
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(path = "/type/{id}")
    public void deleteType(@PathVariable int id){
        Optional<Type> type = typeRepository.findById(id);
        if(type.isEmpty()){
            throw  new RuntimeException("Type not found: " + id);
        }
        typeRepository.deleteById(id);
    }

}
