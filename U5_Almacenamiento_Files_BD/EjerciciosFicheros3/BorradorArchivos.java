package EjerciciosFicheros3;

import java.io.File;

public class BorradorArchivos {

    public static void main(String[] args) {

        File f1 = new File("Documentos/Fotografias");
        File f2 = new File("Documentos/Libros");
        File f3 = new File("Documentos");

        System.out.println("Borrando la carpeta " + f1.getName() + ": " + borraTodo(f1));
        System.out.println("Borrando la carpeta " + f2.getName() + ": " + borraTodo(f2));
        System.out.println("Borrando la carpeta " + f3.getName() + ": " + borraTodo(f3));
    }
    private static String borraTodo(File f) {
        f.exists();

        f.isDirectory();
        f.listFiles();
        f.delete();

        return "";
    }
}
