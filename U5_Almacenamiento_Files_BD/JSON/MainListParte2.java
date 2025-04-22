package JSON;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainListParte2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ObjectMapper mapper = new ObjectMapper();
        List<Usuario> usuarios = new ArrayList<>();

        System.out.println("¿Cuántos usuarios quieres introducir?: ");
        int cantidad = sc.nextInt();

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Introduce los datos del usuario: " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = sc.next();
            System.out.print("Email: ");
            String email = sc.next();
            System.out.print("Edad: ");
            int edad = sc.nextInt();

            usuarios.add(new Usuario(nombre, email, edad));

        }
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(new File("U5_Almacenamiento_Files_BD/JSON/javausuarioLista2.json"), usuarios);
        System.out.println("\nUsuarios guardados correctamente...");

        List<Usuario> usuariosLeidos = mapper.readValue(new File("U5_Almacenamiento_Files_BD/JSON/javausuarioLista2.json"), new TypeReference<>() {});

        System.out.println("\nUsuario leídos desde JSON:");
        for (int i = 0; i < usuariosLeidos.size(); i++) {
            Usuario u = usuariosLeidos.get(i);
            System.out.println("Indice " + i + ": " + u);
        }

        mostrarMayoresDe30(usuariosLeidos);
    }

    public static void mostrarMayoresDe30(List<Usuario> lista) {
        System.out.println("\nUsuarios mayores de 30:");
        for (Usuario u : lista) {
            if (u.getEdad() > 30) {
                System.out.println(u);
            }
        }
    }
}
