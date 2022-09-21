package com.BDll.BDStarWars.service;

import com.BDll.BDStarWars.interfaces.IRelation;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.sql.CallableStatement;

import static com.BDll.BDStarWars.Conection.OracleConexion.getConnection;
@Service
public class RelationService implements IRelation {

    @Override
    public void insertPersonaje(int idPer, int idPlace, int idType) {   // no sirve
        String sql = "{call insertarRelacion(124,32,23)}";

        try {
            CallableStatement prepareCall = getConnection().prepareCall(sql);

//            prepareStatement.setInt(1, idPer);
//            prepareStatement.setInt(2, idPlace);
//            prepareStatement.setInt(3, idType);
            prepareCall.execute();
           // prepareCall.close();

            } catch (Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo insertar");
        }
    }
}
