package com.mycompany.app;

import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.*;
import com.google.gson.Gson;

public class AppDB {
    private static Gson gson=new Gson();
    //private static Map<String, Usuarios> usuariosm =new HashMap<>();
        public static void main( String[] args )
    {
        port(80);
        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        before((req, res) -> res.type("application/json"));
        get("/usuarios",(req,res)->gson.toJson(DAO.getUsuarios()));


       /*  post("/usuarios",(req,res)->{
            String query = req.body();
            System.out.println("1Peticion: "+query);
            Usuarios usuario=gson.fromJson(query,Usuarios.class);
            String id=usuario.getEmail()+"ID";
            usuario.setId(id);
            DAO.addUsuario(usuario.getId(),usuario.getEmail(),usuario.getContrasena());
            return "Se creo Usuario: "+id;
        }); */
        
        
    }
}
