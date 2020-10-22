package com.mycompany.app;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;

public class DAO {
    //private static Conexion conexion = new Conexion();

    public static List<Usuario> getUsuarios() {
        Statement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Usuario> resultado = new ArrayList<>();

        conn = Conexion.getConexion();
        try {
            String sql = "SELECT * from usuario";
            PreparedStatement stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("id"), rs.getString("email"), rs.getString("password"));
                resultado.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (Exception e) {
                    //TODO: handle exception
                }
                rs=null;
            }
            if(stm!=null){
                try {
                    stm.close();
                } catch (Exception e) {
                    //TODO: handle exception
                }
                stm=null;
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (Exception e) {
                    //TODO: handle exception
                }
                conn=null;
            }
        }
        


        return resultado;
    }
}
