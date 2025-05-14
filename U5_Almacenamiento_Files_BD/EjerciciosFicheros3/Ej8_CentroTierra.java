package EjerciciosFicheros3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ej8_CentroTierra {
    public static void main(String[] args) throws FileNotFoundException {

        String base = "U5_Almacenamiento_Files_BD/EjerciciosFicheros3/Documentos/";
        // Crear archivo base y copiar
        crearArchivoBase(base + "copiar.txt");

        // Hacer 10 copias del archivo copiar.txt
        hacerCopias(base, "copiar.txt", 10);

        // Listar todos los archivos y carpetas en la ruta
        listarContenido(base);

        // Crear estructura de subcarpetas y el archivo final
        crearRutaFinalYArchivo(base);
    }

    private static void crearRutaFinalYArchivo(String base) {
        File carpetaFinal = new File(base + "volcan/descenso/aprobar/programacion/");
        File archivoFinal = new File(carpetaFinal + "centroTierra.txt");

        try {
            if (carpetaFinal.mkdirs() || carpetaFinal.exists()) {
                try(FileWriter fw = new FileWriter(archivoFinal)) {
                    fw.write("Sacaré en el examen un 10");
                    System.out.println("Archivo llamado: "+ archivoFinal.getName() + " creado correctamente");
                }
            } else {
                System.out.println("No se pudo crear la estructura de carpetas");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo final: " + e.getMessage());
        }
    }

    private static void listarContenido(String ruta) {
        File directorio = new File(ruta);
        File[] files = directorio.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("[DIRECTORIO]" + file.getName());
            } else {
                System.out.println("[FILE]" + file.getName());
            }
            System.out.println("No se puedo listar el contenido del directorio");
        }
    }

    private static void hacerCopias(String base, String nombreOriginal, int cantidad) throws FileNotFoundException {
        File original = new File(base, nombreOriginal);
        if(!original.exists()) {
            System.out.println("No se pueden hacer copias porque el archivo original no existe");
        }
        for(int i = 1; i < cantidad; i++) {
            File destino = new File(base, nombreOriginal + "_" + i + ".txt");

            FileInputStream in = new FileInputStream(original);
            FileOutputStream out = new FileOutputStream(destino);
        }

    }

    private static void crearArchivoBase(String s) {
        File archivo = new File(s);
        try {
            FileWriter fw = new FileWriter(archivo);
                fw.write("Metemos algo de contenido");

        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + s);
        }
    }
}
