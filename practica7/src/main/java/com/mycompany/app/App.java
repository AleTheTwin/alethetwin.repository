package com.mycompany.app;

import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App {   
    private static Gson gson = new Gson();
    private static Map<String, Usuario> usuariosMap = new HashMap<>();
    public static void main( String[] args ) {
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


        //comienza código
        before((req, res) -> res.type("application/json"));
        get("/hola", (req, res) -> "Hola desde Spark");
        get("/usuarios", (req, res) -> gson.toJson(usuariosMap.values()));
        post("/usuarios", (req, res) -> {
            String query = req.body();
            System.out.println( "peticion: " + query);
            Usuario usuario = gson.fromJson(query, Usuario.class);
            String id = UUID.randomUUID().toString();
            usuario.setId(id);
            usuariosMap.put(id, usuario);
            return "Se creo el usuario con id: " + id;
        });

       

        System.out.println( "Hello World!" );
    }
}
req.body();
            System.out.println( "peticion: " + query);
            Usuario usuario = gson.fromJson(query, Usuario.class);
            String id = UUID.randomUUID().toString();
            usuario.setId(id);
            //usuariosMap.put(id, usuario);
            return "Se creo el usuario con id: " + id;
        });


        System.out.println( "Hello World!" );
    }
}
