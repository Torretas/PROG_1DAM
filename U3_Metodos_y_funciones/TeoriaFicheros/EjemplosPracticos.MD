# Ejemplos Prácticos de Métodos en Java

## 📘 Ejemplo 1: Método Simple para Calcular el Cuadrado de un Número
**Dificultad: Fácil**

Este ejercicio es ideal para entender la estructura básica de un método en Java.

### Ejercicio:
Crea un método llamado `calcularCuadrado` que reciba un número entero como parámetro y devuelva el cuadrado de ese número.

### Código:
```java
public class Calculadora {
    public static int calcularCuadrado(int numero) {
        return numero * numero;
    }

    public static void main(String[] args) {
        int resultado = calcularCuadrado(5);
        System.out.println("El cuadrado de 5 es: " + resultado);
    }
}
````

### Explicación:
calcularCuadrado es un método que toma un parámetro entero numero y devuelve el cuadrado de ese número.
Al ejecutarse, el método calcula el cuadrado de 5 y muestra el resultado en pantalla.

## 📗 Ejemplo 2: Método para Verificar si un Número es Primo
**Dificultad: Media**

Este ejercicio ayuda a los estudiantes a trabajar con condiciones dentro de un método.

### Ejercicio:
Escribe un método llamado esPrimo que reciba un número entero y devuelva true si el número es primo, y false en caso contrario.

### Código:
```java
public class PruebaNumero {
    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int numero = 17;
        System.out.println("¿El número " + numero + " es primo? " + esPrimo(numero));
    }
}
````

### Explicación:
esPrimo verifica si un número entero es primo utilizando un bucle for para dividir el número desde 2 hasta su raíz cuadrada.
Si se encuentra algún divisor, el número no es primo, y el método devuelve false. Si el bucle termina sin encontrar divisores, devuelve true.

## 📕 Ejemplo 3: Método para Calcular el Factorial de un Número con Recursión
**Dificultad: Avanzada**

Este ejercicio introduce la recursión, que es una herramienta poderosa y a la vez compleja en programación.

### Ejercicio:
Crea un método recursivo llamado calcularFactorial que reciba un número entero positivo y devuelva su factorial.

### Código:
````java
public class CalculadoraFactorial {
    public static int calcularFactorial(int numero) {
        if (numero == 0 || numero == 1) {
            return 1;
        } else {
            return numero * calcularFactorial(numero - 1);
        }
    }

    public static void main(String[] args) {
        int numero = 5;
        System.out.println("El factorial de " + numero + " es: " + calcularFactorial(numero));
    }
}
````
### Explicación:
calcularFactorial es un método que llama a sí mismo con el número disminuido en 1, hasta llegar a 0 o 1, que son los casos base.
Este método multiplica cada número en la serie hasta 1, devolviendo el producto total como resultado del factorial.