package RecuperacionFINCURSO.Excepciones;

import java.util.Scanner;

public class ValidadorNota {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean notaValida = false;
        double nota = 0;

        while (!notaValida) {
            System.out.println("Introduzca una nota entre 0 y 10: ");

            try {
                String ent = entrada.nextLine();
                nota = Double.parseDouble(ent);

                if (nota < 0 || nota > 10) {
                    throw new NotaFueraRangoException("La nota debe estar entre 0 y 10");
                }

                notaValida = true;

            } catch (NumberFormatException e) {
                System.out.println("ERROR: Debes introducir un número válido");
            } catch (NotaFueraRangoException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
        System.out.println("Nota registrada correctamente " + nota);
        entrada.close();
    }
}
