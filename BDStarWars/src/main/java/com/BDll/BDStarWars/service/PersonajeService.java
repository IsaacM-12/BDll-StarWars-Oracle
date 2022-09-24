package com.BDll.BDStarWars.service;

import com.BDll.BDStarWars.interfaces.IPersonaje;
import com.BDll.BDStarWars.models.Personaje;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.BDll.BDStarWars.Conection.OracleConexion.getConnection;

// este no se utiliza esta de ejemplo

// una muestra del metodo de forma manual, utilizo el que genera hibernate

@Service
public class PersonajeService implements IPersonaje {

    @Override
    public List<Personaje> findAllPersonajes() {
        List<Personaje> personajesList = new ArrayList<>();

        String sql = "select * from personaje";
        ResultSet respuesta = null;

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            respuesta = ps.executeQuery(sql);
            while (respuesta.next()){
                Personaje personaje = new Personaje();
                personaje.setId(respuesta.getInt("id"));
                personaje.setName(respuesta.getString("name"));
                personaje.setAge(respuesta.getInt("age"));
                personaje.setGender(respuesta.getString("gender"));
                personaje.setHeight(respuesta.getInt("Height"));
                personajesList.add(personaje);
            }

        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo seleccionar");
        }

        return personajesList;
    }

}
