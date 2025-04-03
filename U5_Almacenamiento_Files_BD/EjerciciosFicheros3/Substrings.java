package EjerciciosFicheros3;

public class Substrings {
    public static void main(String[] args) {
        String texto = "3.1415926535";
        // Índice 0 = "3"
        // Índice 1 = "."
        // Índice 2 = "1"
        String decimales = texto.substring(2);
        String[] grupos = decimales.split("(?<=\\G.{2})");
        for (String grupo : grupos) {
            System.out.println(
                    grupo);
        }
    }
}
