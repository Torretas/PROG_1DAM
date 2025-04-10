package main;

public class Palindromo {
    /**
     * Metodo para comprobar si una cadena es un palíndromo.
     *
     * @param cadena La cadena a comprobar
     * @return true si la cadena es un palíndromo, false en caso contrario
     */
    public static boolean esPalindromo(String cadena) {
        if (cadena == null) return false;
        cadena = cadena.toLowerCase().replaceAll("\\s+", "");
        String invertida = new StringBuilder(cadena).reverse().toString();
        return cadena.equals(invertida);
    }
}
