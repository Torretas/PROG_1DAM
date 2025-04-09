package TeoriaFicheros.Serializacion;

import java.io.*;

public class EjemploTransient {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Juanito", "123456789");
        String archivo = "U5_Almacenamiento_Files_BD/Teoria/Serializacion/usuarios.dat";

        try (ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(archivo))) {
            ois.writeObject(usuario);
            System.out.println("Usuario serializado correctamente: " + usuario);
        } catch (IOException e) {
            System.out.println("Error al abrir archivo " + e.getMessage());
        }

        // Deserializar
        try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(archivo))) {
            Usuario usuarioRecuperado = (Usuario) oin.readObject();
            System.out.println("Usuario deserializado correctamente: " + usuarioRecuperado);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al abrir archivo " + e.getMessage());
        }

    }
}
