package EjerciciosFicheros3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MoverCarpetasNIO {
    public static void main(String[] args) throws IOException {
        String carpetabase = "U5_Almacenamiento_Files_BD/EjerciciosFicheros3/Documentos";
        Path base = Paths.get(carpetabase);

        // Creamos las carpetas misCosas y alfabeto
        Path misCosas = base.resolve("Mis Cosas");
        Path alfabeto = base.resolve("Alfabeto");
        Files.createDirectories(misCosas);
        Files.createDirectories(alfabeto);
        System.out.println("Carpetas principales creadas");

        // Mover carpeta Fotografias a Mis cosas
        moverCarpeta(base.resolve("Fotografias"), misCosas.resolve("Fotografias"));

        // Mover carpeta Fotografias a Mis cosas
        moverCarpeta(base.resolve("Libros"), misCosas.resolve("Libros"));

        // Crear carpetas de la A a la Z dentro de la carpeta Alfabeto
        for (char letra = 'A'; letra <= 'Z'; letra++) {
            Path letraDirectorio = alfabeto.resolve(String.valueOf(letra));
            Files.createDirectories(letraDirectorio);
        }
        System.out.println("Organización completa correctamente...");
    }

    public static void moverCarpeta(Path origen, Path destino) throws IOException {
        if (Files.exists(origen)) {
            Files.move(origen, destino, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Movido: " + origen.getFileName() + " -> " + destino.getFileName());
        } else {
            System.out.println("No se encontró el archivo: " + origen.getFileName());
        }
    }
}
