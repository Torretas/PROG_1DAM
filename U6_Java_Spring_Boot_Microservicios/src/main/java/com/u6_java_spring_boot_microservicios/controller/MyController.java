package com.u6_java_spring_boot_microservicios.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
public class MyController {

    // Devuelve texto plano
    @GetMapping(value = "/texto", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getTexto() {
        return "Hola, esto es texto plano.";
    }

    // Devuelve XML
    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public String getXml() {
        return "<mensaje><contenido>Hola, esto es XML</contenido></mensaje>";
    }

    // Devuelve JSON
    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Persona getJson() {
        return new Persona("Alejandro", "Torres");
    }

    // Sin utilizar produces, ya detecta el tipo de contenido. De este modo, Spring decide automáticamente qué formato devolver, según la cabecera Accept.
    @GetMapping("/persona")
    public Persona getPersona() {
        return new Persona("Satoru", "Gojo");
    }

    @GetMapping("/saludo/{nombre}")
    public String saludoPersonalizado(@PathVariable("nombre") String nombre) {
        return "Hola " + nombre;
    }

    // Clase interna para representar una Persona
    static class Persona {
        private String nombre;
        private String apellido;

        public Persona(String nombre, String apellido) {
            this.nombre = nombre;
            this.apellido = apellido;
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellido() {
            return apellido;
        }
    }
}
