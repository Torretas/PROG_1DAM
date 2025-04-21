package JSON;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Crear clase Usuario y una clase MainList para trabajar con objetos en formato JSON. Al final, deberás poder guardar una LISTA de usuarios en un archivo .json y volver a leerla para reconstruir los objetos en memoria
*
* Parte II. Añade un campo int edad a la clase Usuario y, por tanto, modifica el JSON
* Modifica la lista para que se lea desde teclado antes de guardarla
* Crea un metodo que recorra la lista y muestre los usuarios mayores de 30 años
*
* Ejemplo de uso de consola:
*  ¿Cuántos usuarios quieres introducir? 4
*   Introduce los datos del usuario 1:
*   Nombre: X
*   Email: x@
*   Edad: y
*   Introduce los datos del usuario 2:
*   Usaurios leídos:
*
*   Usuarios mayores de 30 años:
*   Usuarios{nombre='Pepe', email='pepe@gmail.com', edad=23}
* */

public class MainList {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Pepe", "pepe@geducaand.es"),
                new Usuario("Juan", "juan@geducaand.es"),
                new Usuario("María", "maria@geducaand.es")
        );

        mapper.writeValue(new File("U5_Almacenamiento_Files_BD/JSON/javausuarioLista.json"), usuarios);
        System.out.println("Usuario guardados en JSON: " + usuarios);

        List<Usuario> usuariosLeidos = mapper.readValue(new File("U5_Almacenamiento_Files_BD/JSON/javausuarioLista.json"), new TypeReference<List<Usuario>>() {});
        for (Usuario u : usuariosLeidos) {
            System.out.println("Usuario desde JSON: " + u);
        }

    }
}
