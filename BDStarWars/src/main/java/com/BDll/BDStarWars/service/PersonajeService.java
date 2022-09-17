package com.BDll.BDStarWars.service;

import com.BDll.BDStarWars.interfaces.IPersonaje;
import com.BDll.BDStarWars.models.Personaje;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.BDll.BDStarWars.Conection.OracleConexion.getConnection;


@Service
public class PersonajeService implements IPersonaje {

    @Override
    public List<Personaje> findAllPersonajes() {
        List<Personaje> personajesList = new ArrayList<>();

        String sql = "select * from personaje";
        //Statement st = null;
        ResultSet rs = null;

        try {
            //st = getConnection();
            PreparedStatement ps = getConnection().prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()){
                Personaje personaje = new Personaje();
                personaje.setId(rs.getInt("id"));
                personaje.setName(rs.getString("name"));
                personaje.setAge(rs.getInt("age"));
                personajesList.add(personaje);
            }

        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo seleccionar");
        }

        return personajesList;
    }

//    @Override
//    public List<Personaje> findAllPersonajes() {
//        return List.of(
//                new Personaje(1,"luke", 30), new Personaje(2,"pepe", 32), new Personaje(3,"R2D2", 300));
//    }

    @Override
    public Personaje findByPersonajeId(int id) {
        return null;
    }

    @Override
    public void deletePersonaje(int id) {

    }

    @Override
    public void updatePersonaje(Personaje personaje) {

    }

    @Override
    public void insertPersonaje(Personaje personaje) {

    }
}
