package JSON;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainListParte2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ObjectMapper mapper = new ObjectMapper();
        List<Usuario> usuarios = new ArrayList<>();

        System.out.println("¿Cuántos usuarios quieres introducir?: ");
        int cantidad = sc.nextInt();

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Introduce los datos del usuario: " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Edad: ");
            int edad = sc.nextInt();

            usuarios.add(new Usuario(nombre, email, edad));

        }
    }
}
