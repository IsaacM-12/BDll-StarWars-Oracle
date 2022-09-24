package com.BDll.BDStarWars.service;

import com.BDll.BDStarWars.interfaces.IRelation;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.sql.CallableStatement;
import static com.BDll.BDStarWars.Conection.OracleConexion.getConnection;

// ni se ejecuta el procedure

@SpringBootApplication
public class RelationService implements IRelation {

    @Override
    public void insertPersonaje(int idPer, int idPlace, int idType) {
        String sql = "{ call insertar_Relacion(?,?,?) }";

        try {
            var con =getConnection();
            CallableStatement prepareCall = con.prepareCall(sql);

            prepareCall.setInt(1, idPer);
            prepareCall.setInt(2, idPlace);
            prepareCall.setInt(3, idType);
            prepareCall.execute();
            prepareCall.close();

        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo insertar");
        }
    }
}


////    private SessionFactory sessionFactory = HibernateUtils.getHibernateQuery();
////
////    @Override
////    public void insertPersonaje(int idPer, int idPlace, int idType) {   // no sirve
////        String sql = "{call insertarRelacion(987,87,67)}";
////
////        try {
////            if (!sessionFactory.getCurrentSession().getTransaction().isActive())
////                sessionFactory.getCurrentSession().getTransaction().begin();
////            SQLQuery sqlQuery = sessionFactory.getCurrentSession()
////                    .createSQLQuery(sql);
////        } catch (Exception e){
////            JOptionPane.showMessageDialog(null,"No se pudo insertar");
////        }
////    }
//}


//
//@SpringBootApplication
//public class RelacionSer implements CommandLineRunner {
//
//    private JdbcTemplate jdbcTemplate;
//
//    @Override
//    public void run(String... args) throws Exception {   // no sirve
//        String sql = "{ call insertarRelacion(?,?,?) }";
//
//        try {
//            jdbcTemplate.update(sql, 12, 12, 13);
//
//        } catch (Exception e){
//            JOptionPane.showMessageDialog(null,"No se pudo insertar");
//        }
//    }
//
//}

