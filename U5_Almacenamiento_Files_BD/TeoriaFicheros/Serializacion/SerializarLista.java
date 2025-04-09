package TeoriaFicheros.Serializacion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializarLista {
    public static void main(String[] args) {
        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Juanito", 18));
        listaPersonas.add(new Persona("Martita", 19));
        listaPersonas.add(new Persona("Pepito", 20));

        String archivo = "U5_Almacenamiento_Files_BD/Teoria/Serializacion/personas.dat";

        // Serializar lista de personas
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(listaPersonas);
            System.out.println("\nLista de personas serializada:");
            listaPersonas.forEach(System.out::println);
            //System.out.println("Objeto serializado: " + listaPersonas);

            System.out.println();

            // Personalizar el formato:
            System.out.println(listaPersonas.stream()
                    .map(Persona::toString)
                    .reduce("", (a, b) -> a + " | " + b).describeConstable().orElse(""));

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo" + e.getMessage());
        }

        // Deserializar (Cargar/Leer un objeto desde un archivo binario

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            List<Persona> listaRecuperada = (List<Persona>) in.readObject(); // Recupera la lista del archivo

            System.out.println("\nLista deserializada:");
            listaRecuperada.forEach(System.out::println);
            //

            System.out.println("\nLista deserializada sin forEach:");
            System.out.println("Objeto deserializado: " + listaRecuperada);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo" + e.getMessage());
        }
    }
}
