package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import main.Palindromo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

public class PalindromoTest {

    public static int notaTotal = 0;

    @Test
    public void prueba1() {
        assertTrue(Palindromo.esPalindromo("anita lava la tin"));
        notaTotal += 2;
    }

    @Test
    public void prueba2() {
        assertFalse(Palindromo.esPalindromo("Java mola"));
        notaTotal += 2;
    }

    @Test
    public void prueba3() {
        assertTrue(Palindromo.esPalindromo("Somos o no somos"));
        notaTotal += 2;
    }

    @Test
    public void prueba4() {
        assertFalse(Palindromo.esPalindromo("A mamá Roma le aviva el amor a mamá"));
        notaTotal += 2;
    }

    @Test
    public void prueba5() {
        assertTrue(Palindromo.esPalindromo("oso"));
        notaTotal += 2;
    }

    @AfterAll
    public static void mostrarNotaTotal() {
        System.out.println("\nNota final: " + notaTotal);
    }
}
