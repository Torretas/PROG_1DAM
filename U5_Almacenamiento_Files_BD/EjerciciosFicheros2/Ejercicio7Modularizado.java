package EjerciciosFicheros2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
* **Ejercicio 7: Buscar una palabra en un archivo**
 Escribe un programa que busque una palabra específica dentro del archivo `datos.txt` e indique cuántas veces aparece.
*
* */
public class Ejercicio7Modularizado {
    public static void main(String[] args) {

        String archivo = "U5_Almacenamiento_Files_BD/EjerciciosFicheros2/datos5.txt";

        String palabraBuscada = "mode";
        int numeroVeces = contarVecesEnArchivo(archivo, palabraBuscada);

        System.out.println("La palabra: " + palabraBuscada + " aparece : " + numeroVeces + " en el archivo");
    }

    public static int contarVecesEnArchivo(String rutaArchivo, String palabraBuscada) {
        int contador = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contador+= contarVecesEnLinea(linea, palabraBuscada);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return contador;
    }
    // Metodo para contar las ocurrencias de una aplabra en una línea de texto
    private static int contarVecesEnLinea(String linea, String palabraBuscada) {
        int contador = 0;
        String lineaMinusculas = linea.toLowerCase();
        String palabraMinusculas = palabraBuscada.toLowerCase();

        int posicion = 0;
        while((posicion = lineaMinusculas.indexOf(lineaMinusculas, posicion)) != -1) {
            contador++;
            posicion += palabraMinusculas.length();
        }
        return contador;
    }
}
