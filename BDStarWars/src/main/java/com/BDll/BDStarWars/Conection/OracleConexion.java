package com.BDll.BDStarWars.Conection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConexion {

    private static Connection conn = null;
    private static String login = "c##misaac"; //usuario
    private static String clave = "misaac";
    private static String url = "jdbc:oracle:thin:@192.168.100.148:1521:bd2";

    public static Connection getConnection(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url,login,clave);
            conn.setAutoCommit(false);

            if(conn != null){
                System.out.println("Conexion Exitosa");
            }
            else {
                System.out.println("Conexion Erronea");
            }
        } catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Conexion ERRONEA " + e.getMessage());
        }
        return conn;
    }

    public void desconexion() {
        try {
            conn.close();
        } catch (Exception e)
        {
            System.out.println("Error al desconectar " + e.getLocalizedMessage());
        }
    }

    public static void main(String[] args){
        OracleConexion c = new OracleConexion();
        getConnection();
    }

}
