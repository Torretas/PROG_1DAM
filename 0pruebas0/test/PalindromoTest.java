package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import main.Palindromo;
import org.junit.jupiter.api.Test;

public class PalindromoTest {

    @Test
    public void prueba1() {
        assertTrue(Palindromo.esPalindromo("anita lava la tina"));
    }

    @Test
    public void prueba2() {
        assertFalse(Palindromo.esPalindromo("Java mola"));
    }

    @Test
    public void prueba3() {
        assertTrue(Palindromo.esPalindromo("Somos o no somos"));
    }

    @Test
    public void prueba4() {
        assertTrue(Palindromo.esPalindromo("A mamá Roma le aviva el amor a mamá"));
    }

    @Test
    public void prueba5() {
        assertTrue(Palindromo.esPalindromo("oso"));
    }
}
