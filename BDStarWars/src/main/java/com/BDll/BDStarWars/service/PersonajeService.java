package com.BDll.BDStarWars.service;

import com.BDll.BDStarWars.interfaces.IPersonaje;
import com.BDll.BDStarWars.models.Personaje;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonajeService implements IPersonaje {

//    @Override
//    public List<Personaje> findAllPersonajes() {
//        var personajesList = new ArrayList<Personaje>();
//
//        String sql = "select * from personajes;";
//        Statement st = null;
//        ResultSet rs = null;
//
//        try {
//            st = getConnection();
//            rs = st.executeQuery(sql);
//            while (rs.next()){
//                personajesList.add(rs.toString());
//            }
//            return personajesList;
//
//        } catch (Exception e){
//            JOptionPane.showMessageDialog(null,"No se pudo seleccionar");
//        }
//
//        return null;
//    }

    @Override
    public List<Personaje> findAllPersonajes() {
        return List.of(
                new Personaje(1,"luke", 30), new Personaje(2,"pepe", 32), new Personaje(3,"R2D2", 300));
    }

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
