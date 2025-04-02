package EjerciciosFicheros2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

// Buscar palabra en un archivo
public class Ejercicio7NIO {
    public static void main(String[] args) {
        Path path = Paths.get("U5_Almacenamiento_Files_BD/EjerciciosFicheros2/ejercicio1NIO.txt");
        String palabraBuscada = "grandes";

        try (Stream<String> stream = Files.lines(path);){
            long cuenta = stream.filter(line -> line.contains(palabraBuscada)).count();
            System.out.println("La palabra buscada es: " + palabraBuscada + " y aparece: " + cuenta + " veces.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
