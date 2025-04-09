package TeoriaFicheros.Serializacion;

import java.io.*;

public class SerializacionEjemplo {
    public static void main(String[] args) {
        Persona p1 = new Persona("Juan", 30);

        // Serializar (Guardar/escribir un objeto en un archivo binario)

        String archivo = "U5_Almacenamiento_Files_BD/Teoria/Serializacion/personas.dat";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(p1);
            System.out.println("Objeto serializado: " + p1);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo" + e.getMessage());
        }

        // Deserializar (Cargar/Leer un objeto desde un archivo binario

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            //System.out.println(in.readObject());
            Persona p2 = (Persona) in.readObject();
            System.out.println("Objeto deserializado: " + p2);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo" + e.getMessage());
        }


    }
}
