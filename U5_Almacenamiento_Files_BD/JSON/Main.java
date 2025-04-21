package JSON;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        Usuario user = new Usuario("Pepe", "pepe@gmail.com");

        ObjectMapper mapper = new ObjectMapper();

        // Convertir el objeto a JSON
        /*/mapper.writeValue(new File("U5_Almacenamiento_Files_BD/JSON/javausuario.json"), user);
        System.out.println("Usuario guardado en JSON: " + user);
*/
        // Leer el JSON y convertirlo a objeto
        //Usuario user2 = mapper.readValue(new File("U5_Almacenamiento_Files_BD/JSON/javausuario.json"), Usuario.class);
        /*Usuario[] usuarios = mapper.readValue(new File("U5_Almacenamiento_Files_BD/JSON/javausuario.json"), Usuario[].class);
        for (Usuario u : usuarios) {
            System.out.println("Usuario leído desde JSON: " + u);
        }*/

        List<Usuario> listaUsuarios = mapper.readValue(new File("U5_Almacenamiento_Files_BD/JSON/javausuario.json"), new TypeReference<List<Usuario>>(){});
        for (Usuario u : listaUsuarios) {
            System.out.println("Usuario desde JSON: " + u);
        }

        //System.out.println("Usuario leído desde JSON: " + user2);

    }
}
