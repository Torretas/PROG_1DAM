# Introducción a la Programación Orientada a Objetos (POO) en Java

La Programación Orientada a Objetos (POO) es un paradigma de programación basado en el concepto de **clases** y **objetos**. Permite estructurar el código en unidades llamadas objetos, que representan entidades con propiedades y comportamientos específicos. En Java, la POO es fundamental, y todos los programas se construyen en torno a **clases** y **objetos**.

---

## 📘 Conceptos Básicos de la POO

### Clase
Una **clase** es como un molde o plantilla que define las propiedades (atributos) y comportamientos (métodos) que tendrán los objetos de ese tipo. En Java, se declara con la palabra clave `class`.

### Objeto
Un **objeto** es una instancia de una clase. Cuando se crea un objeto, este adquiere las propiedades y comportamientos definidos en su clase.

### Encapsulamiento
El **encapsulamiento** es uno de los principios básicos de la POO. Permite proteger los datos dentro de una clase, restringiendo el acceso a los mismos mediante modificadores de acceso (`public`, `protected`, `private`). Este concepto asegura que solo los métodos de la clase puedan acceder y modificar los atributos internos.

---

## Modificadores de Acceso: `public`, `protected` y `private`

Los modificadores de acceso definen quién puede acceder a los atributos y métodos de una clase:

1. **public**: Accesible desde cualquier clase.
2. **protected**: Accesible desde la misma clase, subclases y clases del mismo paquete.
3. **private**: Accesible solo dentro de la propia clase. Es la forma más restrictiva de acceso.

### Ejemplo Práctico

Vamos a crear una clase `CuentaBancaria` que tendrá atributos privados y métodos con distintos niveles de acceso. Este ejemplo muestra cómo aplicar los modificadores de acceso `public`, `protected` y `private` en métodos.

---

### Código

```java
public class CuentaBancaria {
    // Atributos privados, solo accesibles desde dentro de la clase
    private String titular;
    private double saldo;

    // Constructor público para inicializar los atributos
    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // Metodo público que permite consultar el saldo
    public double consultarSaldo() {
        return saldo;
    }

    // Metodo público para realizar depósitos en la cuenta
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito exitoso. Nuevo saldo: " + saldo);
        } else {
            System.out.println("La cantidad debe ser positiva.");
        }
    }

    // Metodo protegido para mostrar los datos del titular
    // Solo accesible desde clases en el mismo paquete o subclases
    protected void mostrarTitular() {
        System.out.println("Titular de la cuenta: " + titular);
    }

    // Metodo privado para calcular los intereses anuales
    // Solo accesible dentro de esta clase
    private double calcularInteresAnual() {
        final double TASA_INTERES = 0.03; // Tasa de interés del 3%
        return saldo * TASA_INTERES;
    }

    // Metodo público que muestra el interés anual usando el método privado
    public void mostrarInteresAnual() {
        double interes = calcularInteresAnual();
        System.out.println("Interés anual estimado: " + interes);
    }
}

// Clase Principal para probar la clase CuentaBancaria
class PruebaCuentaBancaria {
    public static void main(String[] args) {
        // Crear un objeto de la clase CuentaBancaria
        CuentaBancaria miCuenta = new CuentaBancaria("Juan Pérez", 1000);

        // Acceso a métodos públicos
        System.out.println("Saldo inicial: " + miCuenta.consultarSaldo());
        miCuenta.depositar(500);

        // Llamar al metodo para mostrar el interés anual
        miCuenta.mostrarInteresAnual();

        // Intento de acceso al metodo protegido
        // miCuenta.mostrarTitular(); // Error: no se puede acceder directamente desde aquí
    }
}
````

### Explicación del Código
- **Atributos Privados (private):**
  - Los atributos titular y saldo están marcados como privados, lo que asegura que solo sean accesibles y modificables dentro de la clase CuentaBancaria.

- **Métodos Públicos (public):**
  - Los métodos consultarSaldo, depositar, y mostrarInteresAnual permiten acceso a operaciones importantes de la cuenta y se pueden invocar desde cualquier clase.

 - **Método Protegido (protected):**
   - El método mostrarTitular es protegido, lo que permite su uso en subclases o clases dentro del mismo paquete, pero restringe su acceso desde fuera de estos contextos.

- **Método Privado (private):**
  - El método calcularInteresAnual es privado y encapsula la lógica del cálculo de intereses, asegurando que solo sea llamado desde dentro de la clase CuentaBancaria.