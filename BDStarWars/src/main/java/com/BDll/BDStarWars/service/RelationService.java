package com.BDll.BDStarWars.service;

import com.BDll.BDStarWars.interfaces.IRelation;
import org.springframework.stereotype.Service;

import javax.persistence.StoredProcedureParameter;
import javax.swing.*;
import java.sql.CallableStatement;

import static com.BDll.BDStarWars.Conection.OracleConexion.getConnection;
@Service
public class RelationService implements IRelation {

    @Override
    public void insertPersonaje(int idPer, int idPlace, int idType) {   // no sirve
        String sql = "{call insertarRelacion(?,?,?)}";

        try {
            CallableStatement prepareCall = getConnection().prepareCall(sql);
            System.out.println(idPer);

            prepareCall.setInt("idPersonaje2", idPer);
            prepareCall.setInt("idType", idPlace);
            prepareCall.setInt("idPlace", idType);
            prepareCall.executeQuery();
            prepareCall.close();

            } catch (Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo insertar");
        }
    }
}
