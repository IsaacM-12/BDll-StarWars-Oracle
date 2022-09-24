package com.BDll.BDStarWars.service;

import com.BDll.BDStarWars.interfaces.IRelation;
import org.springframework.stereotype.Service;
import javax.persistence.*;

@Service
public class RelationService implements IRelation {

    @PersistenceContext
    EntityManager entityManager;

    //String sql = "{ call insertar_Relacion(?,?,?) }";
    @Override
    public void insertPersonaje(int idPer, int idPlace, int idType) {

        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery("insertar_Relacion")
                .registerStoredProcedureParameter("idPersonajeE",Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("idTypeE",Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("idPlaceE",Integer.class, ParameterMode.IN)
                .setParameter("idPersonajeE", idPer)
                .setParameter("idTypeE", idType)
                .setParameter("idPlaceE", idPlace);
        query.execute();
    }
}