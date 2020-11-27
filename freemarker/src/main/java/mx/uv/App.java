package mx.uv;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import static spark.Spark.get;

public class App {

    public static void main(String args[]) {

        get("/hello", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");
            
            return new ModelAndView(attributes, "hello.ftl");
        }, new FreeMarkerEngine());

    }

}