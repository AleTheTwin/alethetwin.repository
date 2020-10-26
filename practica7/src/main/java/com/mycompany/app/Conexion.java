package com.mycompany.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import oracle.jdbc.*;
//import oracle.jdbc.pool.OracleDataSource;

public class Conexion {
    private static String url = "jdbc:mysql://127.0.0.1:3306/sistemasweb?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false";

    private static String driverName = "com.mysql.cj.jdbc.Driver";
    //private static String url = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
    //private static String username = "c##sw";
    private static String username = "root";
    //private static String password = "pass";
    private static String password = "071419";
    private static Connection conexion = null;

    public static Connection getConexion(){
        
       try{
            Class.forName(driverName);
            conexion = DriverManager.getConnection(url, username, password);
            System.out.println("Sucess Connection");
        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Failed to create Connection");
        } catch(ClassNotFoundException e){
            System.out.println("Driver not found");
        } 
        
        /*
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setURL(url); // jdbc:oracle:thin@//[nombre de host]:[puerto]/[nombre de servicio BD]
            ods.setUser(username); // [nombre de usuario]
            ods.setPassword(password); // [contraseña]
            conexion = ods.getConnection();
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return conexion;
    }
}