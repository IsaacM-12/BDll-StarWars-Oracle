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
                .registerStoredProcedureParameter("idPersonaje2",Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("idType",Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("idPlace",Integer.class, ParameterMode.IN)
                .setParameter("idPersonaje2", idPer)
                .setParameter("idType", idType)
                .setParameter("idPlace", idPlace);
        query.execute();
    }
}