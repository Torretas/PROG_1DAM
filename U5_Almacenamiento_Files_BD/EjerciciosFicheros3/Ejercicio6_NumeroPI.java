package EjerciciosFicheros3;

import java.io.*;
import java.util.Scanner;

public class Ejercicio6_NumeroPI {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el número entero a buscar: ");
        String numeroBuscar = sc.nextLine().trim();

        File archivo = new File("U5_Almacenamiento_Files_BD/EjerciciosFicheros3/Documentos/pi-million.txt");
        /*
        * Scanner lector = new Scanner(archivo);
        * String decimalesPI = lector.nextLine().substring(2);
        * lector.close();
        *
        * */

        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                sb.append(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo" +  e.getMessage());
        }
        String decimalesPI = sb.toString();

        // OPCION A: Búsqueda MANUAL del número en los decimales de PI
        /* ¿Cómo recorrer la cadena? Recorrerá la cadena desde el índice 0 hasta el índice donde aún se puede extraer un subtring de la longitud del patron a buscar (numeroBuscar) decimalesPI.substring(i, i + numeroBuscar.length() lo que hace es extraer una subcadena de longitud igual a la del numeroBuscar, comenzando por i
         Se compara la subcadena extraída con numeroBuscar mediante equals()
         */

        boolean encontrado = false;
        int indiceEncontrado = 0;
        for (int i=0; i < decimalesPI.length() - numeroBuscar.length(); i++) {
            if (numeroBuscar.equals(decimalesPI.substring(i, i + numeroBuscar.length()))) {
                encontrado = true;
                indiceEncontrado = i;
                break;
            }
        }
        if (encontrado) {
            System.out.println("El número " +  numeroBuscar + " aparece en los decimales de PI del archivo:  " + archivo.getName() + " en la posición " + indiceEncontrado);
        } else {
            System.out.println("El número " +  numeroBuscar + " NO aparece en los decimales de PI del archivo:  " + archivo.getName());
        }

        // OPCION B. Busqueda NO MANUAL empleando indexOf
        // probar también con indexOf
        if(decimalesPI.contains(numeroBuscar)) {
            System.out.println("El número " +  numeroBuscar + " aparece en los decimales de PI del archivo:  " + archivo.getName() + " en la posición " + decimalesPI.indexOf(numeroBuscar));
        } else {
            System.out.println("El número " +  numeroBuscar + " NO aparece en los decimales de PI del archivo:  " + archivo.getName());
        }
    }
}
