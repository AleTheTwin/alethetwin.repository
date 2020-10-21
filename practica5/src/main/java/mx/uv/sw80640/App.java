package mx.uv.sw80640;

import static spark.Spark.*;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Hello world!
 *
 */
public class App 
{
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


        get("/", (req, res) -> "Hola desde Spark");
        get("/hola", (req, res) -> {
            System.out.println("Request: " + req.queryParams());
            System.out.println("Request: " + req.queryParams("PrmEmail"));
            System.out.println("Request: " + req.queryParams("PrmPassword"));
            System.out.println("Request: " + req.body());
            System.out.println("Request: " + req.contentType());
            return "Hola " + req.queryParams("PrmEmail") + " desde spark";
        });
        post("/adios", (req, res) -> {
            System.out.println("Request: " + req.body());
            System.out.println("Request: " + req.queryParams("PrmEmail"));
            System.out.println("Request: " + req.queryParams("PrmPassword"));
            System.out.println("Request: " + req.body());
            System.out.println("Request: " + req.contentType());

            return "Hola " + req.queryParams("PrmEmail") + " desde spark";
        });

        post("/adiosJason", (req, res) -> {
            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse(req.body());
            JsonObject peticion = arbol.getAsJsonObject();

            System.out.println("Request: " + peticion.get("PrmEmail"));
            System.out.println("Request: " + peticion.get("PrmPassword"));
            System.out.println("Request: " + req.body());
            System.out.println("Request: " + req.contentType());

            return "Hola " + peticion.get("PrmEmail") + " desde spark";
        });
    }
}
