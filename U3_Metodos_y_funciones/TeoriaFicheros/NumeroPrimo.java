package TeoriaFicheros;

import java.util.Scanner;

public class NumeroPrimo {
    public static void main(String[] args) {
        int numero;
        System.out.println("Introduce un numero entero positivo: ");
        Scanner sc = new Scanner(System.in);
        numero = sc.nextInt();

        if (esPrimo(numero)) {
            System.out.println("El numero es primo");
        } else {
            System.out.println("El numero no es primo");
        }
    }

    public static boolean esPrimo(int numero) {
        if (numero < 2) {
            return false;
        }
        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}
