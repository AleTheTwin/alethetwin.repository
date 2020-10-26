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
          String sql = "SELECT * from Usuario";
            
            //PreparedStatement stmt = conn.prepareStatement(sql);
            
            stm = conn.createStatement();
            
            rs = stm.executeQuery(sql);
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
                }
                rs=null;
            }
            if(stm!=null){
                try {
                    stm.close();
                } catch (Exception e) {
                }
                stm=null;
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (Exception e) {
                }
                conn=null;
            }
        }
        return resultado;
    }

    public static String createUsuario(Usuario usuario) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String msj = "";
        ResultSet rs = null;

        conn = Conexion.getConexion();
        try {
            String sql = "insert into usuario (id, email, password) values (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getId());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getPassword());
            if(stmt.executeUpdate() > 0) {
                msj = "Se agrego correctamente el usuario";
            } else {
                msj = "No se agrego correctamente el usuario";
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs=null;
            }
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt=null;
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (Exception e) {
                }
                conn=null;
            }
        }
        return msj;
    }

    public static String deleteUsuario(Usuario usuario) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String msj = "";
        ResultSet rs = null;

        conn = Conexion.getConexion();
        try {
            String sql = "delete from usuario where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getId());
            if(stmt.executeUpdate() > 0) {
                msj = "Se elimino correctamente el usuario";
            } else {
                msj = "No se elimino correctamente el usuario";
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs=null;
            }
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt=null;
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (Exception e) {
                }
                conn=null;
            }
        }
        return msj;
    }

    public static String updateUsuario(Usuario usuario, Usuario nuevoUsuario) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String msj = "";
        ResultSet rs = null;

        conn = Conexion.getConexion();
        try {
            String sql = "update usuario set email= ? , password= ? where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nuevoUsuario.getEmail());
            stmt.setString(2, nuevoUsuario.getPassword());
            stmt.setString(3, usuario.getId());
            if(stmt.executeUpdate() > 0) {
                msj = "Se actualizo correctamente el usuario";
            } else {
                msj = "No se actualizo correctamente el usuario";
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs=null;
            }
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt=null;
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (Exception e) {
                }
                conn=null;
            }
        }
        return msj;
    }
}
