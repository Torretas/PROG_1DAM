package EjerciciosFicheros2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The type Ejercicio 7 modularizado.
 */
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

    /**
     * Contar veces en archivo int.
     * Recibe la ruta del archivo y la palabra a buscar
     * Inicializa un contador a cero
     * Usa un try-with-resources para asegurar que el archivo se cierre automáticamente
     * Crea un BufferedReader para leer el archivo línea por línea
     * Para cada línea, llama al metodo contarVecesEnLinea y suma su resultado al contador
     * Maneja posibles excepciones de entrada/salida
     * Devuelve el contador total
     *
     * @param rutaArchivo    the ruta archivo
     * @param palabraBuscada the palabra buscada
     * @return the int
     */
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

    /**
     * Metodo para contar las ocurrencias de una aplabra en una línea de texto
     *   Recibe una línea de texto y la palabra a buscar
     *   Convierte tanto la línea como la palabra a minúsculas para una búsqueda que no distinga mayúsculas/minúsculas
     *   Inicializa una variable posicion para recorrer la línea
     *   Usa un bucle while para buscar todas las ocurrencias:
     *   indexOf(palabraMinusculas, posicion) busca la palabra a partir de la posición actual
     *   Si encuentra la palabra, devuelve su posición; si no, devuelve -1
     *   Si encontró la palabra, incrementa el contador
     *   Avanza la posición sumando la longitud de la palabra para buscar desde después de la ocurrencia actual
     *   Devuelve el contador de ocurrencias en esta línea
     *
     * @param linea          the linea
     * @param palabraBuscada the palabra buscada
     * @return the int
     */
    public static int contarVecesEnLinea(String linea, String palabraBuscada) {
        int contador = 0;
        String lineaMinusculas = linea.toLowerCase();
        String palabraMinusculas = palabraBuscada.toLowerCase();

        int posicion = 0;
        while((posicion = lineaMinusculas.indexOf(palabraMinusculas, posicion)) != -1) {
            contador++;
            posicion += palabraMinusculas.length();
        }
        return contador;
    }
}
