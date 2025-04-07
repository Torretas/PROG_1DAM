package EjerciciosFicheros3;

import java.io.File;
/*
* EjercicioA. Crear y mover carpetas

Implementa un programa que cree, dentro de ‘Documentos’, dos nuevas carpetas: ‘Mis Cosas’ y ‘Alfabeto’. Mueve las carpetas ‘Fotografias’ y ‘Libros’ dentro de ‘Mis Cosas’. Luego crea dentro de ‘Alfabeto’ una carpeta por cada letra del alfabeto (en mayúsculas): ‘A’, ‘B’, ‘C’... ‘Z’. Te serán de ayuda los códigos numéricos ASCII: https://elcodigoascii.com.ar
*
*
* */

public class MoverCarpetasIO {
    public static void main(String[] args) {
        File base = new File("U5_Almacenamiento_Files_BD/EjerciciosFicheros3/Documentos");

        File misCosas = new File(base, "Mis Cosas");
        File alfabeto = new File(base, "Libros");
        misCosas.mkdirs();
        alfabeto.mkdirs();

        File fotos = new File(base, "Fotografias");
        File libros = new File(base, "Libros");

        if (fotos.exists()) {
            fotos.renameTo(new File(misCosas, fotos.getName()));
        }
        if (libros.exists()) {
            libros.renameTo(new File(misCosas, libros.getName()));
        }

        // Pra hacer uso de https://elcodigoascii.com.ar
        // for(int i = 65; i<=90; i++) {
        //     siendo 65 el entero del caracter A y 90 el del Z
        // }

        for (char letra = 'A'; letra <= 'Z'; letra++) {
            File carpetaLetra = new File(alfabeto, String.valueOf(letra));
            carpetaLetra.mkdir();
        }
        System.out.println("Carpetas creadas y movidas correctamente...");




    }
}
