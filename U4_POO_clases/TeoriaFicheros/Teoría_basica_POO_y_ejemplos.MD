# Programación Orientada a Objetos (POO) en Java

## 📚 Índice
1. [¿Qué es la Programación Orientada a Objetos (POO)?](#qué-es-la-programación-orientada-a-objetos-poo)
2. [Conceptos Básicos de POO](#conceptos-básicos-de-poo)
    - [Clases y Objetos](#clases-y-objetos)
    - [Atributos](#atributos)
    - [Métodos](#métodos)
    - [Encapsulación](#encapsulación)
    - [Herencia](#herencia)
    - [Polimorfismo](#polimorfismo)
3. [Modificadores de Acceso](#modificadores-de-acceso)
4. [Ejemplos Prácticos](#ejemplos-prácticos)

---

## ¿Qué es la Programación Orientada a Objetos (POO)?
La Programación Orientada a Objetos (POO) es un paradigma de programación que organiza el software en **clases** y **objetos**. Este enfoque modela conceptos del mundo real para hacer el código más modular, reutilizable y fácil de mantener.

## Conceptos Básicos de POO

### Clases y Objetos
- **Clase**: Es un molde o plantilla que define las características (atributos) y comportamientos (métodos) de un conjunto de objetos.
- **Objeto**: Es una instancia de una clase. Representa algo específico basado en la plantilla de la clase.

(Código de ejemplo: Clase y Objeto)
````java
class Persona {
    String nombre;
    int edad;

    public void saludar() {
        System.out.println("Hola, soy " + nombre + " y tengo " + edad + " años.");
    }
}
````
---

### Atributos
Los atributos son variables que representan las propiedades o características de una clase.

(Código de ejemplo: Atributos)
````java
class Persona {
    String nombre = "Juan";
    int edad = 25;
}
````
---

### Métodos
Los métodos son funciones definidas dentro de una clase que describen los comportamientos de los objetos.

(Código de ejemplo: Métodos)
````java
class Calculadora {
    public int sumar(int a, int b) {
        return a + b;
    }
}
````
---

### Encapsulación
La encapsulación consiste en ocultar los datos de una clase y controlar su acceso mediante métodos. Se usa para proteger el estado interno de los objetos.

(Código de ejemplo: Encapsulación)
````java
class Persona {
    private String nombre;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
````
---

### Herencia
La herencia permite que una clase (subclase) herede atributos y métodos de otra clase (superclase).

(Código de ejemplo: Herencia)
````java
class Animal {
    
   // Metodo genérico para dormir
    void comer() {
        System.out.println("Este animal está comiendo.");
    }
   // Metodo genérico para dormir
   void dormir() {
      System.out.println("El animal está durmiendo.");
   }
}

// Subclase específica que extiende o hereda de la clase Animal
class Perro extends Animal {
    void ladrar() {
        System.out.println("El perro está ladrando.");
    }
}

// Clase principal para probar la herencia
public class HerenciaEjemplo {
   public static void main(String[] args) {
      // Crear un objeto de la clase Perro
      Perro miPerro = new Perro();

      // Usar métodos heredados de la clase Animal
      miPerro.comer();
      miPerro.dormir();

      // Usar un método específico de la clase Perro
      miPerro.ladrar();
   }
}
````
---

### Polimorfismo
El polimorfismo permite que un método se comporte de manera diferente según la clase que lo implemente.

(Código de ejemplo: Polimorfismo)
````java
class Vehiculo {
    void arrancar() {
        System.out.println("El vehículo está arrancando.");
    }
}

class Coche extends Vehiculo {
    @Override
    void arrancar() {
        System.out.println("El coche está arrancando.");
    }
}
````
---

## Modificadores de Acceso
Los modificadores de acceso en Java definen la visibilidad de los atributos y métodos. Los más comunes son:

1. **`public`**: Accesible desde cualquier lugar.
2. **`private`**: Accesible solo dentro de la clase.
3. **`protected`**: Accesible dentro del mismo paquete o por clases derivadas.
4. **Sin modificador** (default): Accesible solo dentro del mismo paquete.

| **Modificador**            | **Visibilidad dentro de la misma clase** | **Visibilidad dentro del mismo paquete** | **Visibilidad en subclases (dentro de otro paquete)** | **Visibilidad desde otras clases (fuera del paquete)** |
|-----------------------------|------------------------------------------|-------------------------------------------|------------------------------------------------------|-------------------------------------------------------|
| `private`                  | ✔️ Visible                              | ❌ No visible                             | ❌ No visible                                        | ❌ No visible                                         |
| `public`                   | ✔️ Visible                              | ✔️ Visible                                | ✔️ Visible                                           | ✔️ Visible                                            |
| `protected`                | ✔️ Visible                              | ✔️ Visible                                | ✔️ Visible (solo a través de herencia)               | ❌ No visible si no es heredado                       |
| Sin modificador (paquete)  | ✔️ Visible                              | ✔️ Visible                                | ❌ No visible (incluso si es heredado)               | ❌ No visible                                         |


(Código de ejemplo: Modificadores de acceso)
````java
class Persona {
    public String nombre;
    private int edad;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
````
---

## Ejemplos Prácticos

### Ejemplo 1: Encapsulación y Métodos
(Código de ejemplo: Encapsulación y Métodos)
````java
public class CuentaBancaria {
    private String titular;
    private double saldo;

    // Constructor
    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // Metodo para depositar dinero
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito exitoso. Saldo actual: " + saldo);
        } else {
            System.out.println("El monto a depositar debe ser positivo.");
        }
    }

    // Metodo para retirar dinero
    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Retiro exitoso. Saldo actual: " + saldo);
        } else if (monto > saldo) {
            System.out.println("Fondos insuficientes.");
        } else {
            System.out.println("El monto a retirar debe ser positivo.");
        }
    }
    
    public double consultarSaldo() {    // Metodo para consultar el saldo
        return saldo;
    }
    public String getTitular() {     // Metodo para obtener el titular de la cuenta
        return titular;
    }
    public void setTitular(String titular) {    // Metodo para cambiar el titular de la cuenta
        this.titular = titular;
    }

    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("Juan Pérez", 5000);

        System.out.println("Titular: " + cuenta.getTitular());
        System.out.println("Saldo inicial: " + cuenta.consultarSaldo());

        cuenta.depositar(2000);
        cuenta.retirar(3000);
        cuenta.retirar(5000);  // Caso de fondos insuficientes
        cuenta.depositar(-500);  // Caso de monto no válido
    }
}
````
**Encapsulación**:

 - Los atributos de CuentaBancaria son privados y solo accesibles mediante métodos públicos.
 - Se validan las entradas para evitar inconsistencias (como un saldo negativo).
---

### Ejemplo 2: Herencia y Polimorfismo
(Código de ejemplo: Herencia y Polimorfismo)
````java
// Clase base
class Empleado {
    protected String nombre;
    protected double salarioBase;

    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    // Metodo polimórfico para calcular el salario
    public double calcularSalarioMensual() {
        return salarioBase;
    }

    public String getNombre() {
        return nombre;
    }
}

// Subclase Gerente
class Gerente extends Empleado {
    private double bono;

    public Gerente(String nombre, double salarioBase, double bono) {
        super(nombre, salarioBase);
        this.bono = bono;
    }

    @Override
    public double calcularSalarioMensual() {
        return salarioBase + bono;
    }
}

// Subclase Desarrollador
class Desarrollador extends Empleado {
    private int horasExtras;
    private double pagoPorHoraExtra;

    public Desarrollador(String nombre, double salarioBase, int horasExtras, double pagoPorHoraExtra) {
        super(nombre, salarioBase);
        this.horasExtras = horasExtras;
        this.pagoPorHoraExtra = pagoPorHoraExtra;
    }

    @Override
    public double calcularSalarioMensual() {
        return salarioBase + (horasExtras * pagoPorHoraExtra);
    }
}

// Clase principal
public class Empresa {
    public static void main(String[] args) {
        Empleado empleado1 = new Gerente("Ana López", 3000, 1000);
        Empleado empleado2 = new Desarrollador("Luis García", 2000, 10, 25);

        System.out.println(empleado1.getNombre() + " tiene un salario mensual de: " + empleado1.calcularSalarioMensual());
        System.out.println(empleado2.getNombre() + " tiene un salario mensual de: " + empleado2.calcularSalarioMensual());
    }
}
````
**Herencia y Polimorfismo**:
 - Empleado es la clase base, y sus subclases (Gerente, Desarrollador) sobrescriben el método calcularSalarioMensual.
 - Gracias al polimorfismo, podemos tratar todos los objetos de las subclases como si fueran de la clase base, mientras ejecutan su versión específica de los métodos.

### Ejemplo 3: Uso de Constructores
(Código de ejemplo: Constructores)
````java
class Persona {
    String nombre;
    int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}
````
---

### Ejemplo 4: Clase con Métodos Públicos, Privados y Protegidos
(Código de ejemplo: Métodos Públicos, Privados y Protegidos)
````java
class Calculadora {
    public int sumar(int a, int b) {
        return a + b;
    }

    private int restar(int a, int b) {
        return a - b;
    }

    protected int multiplicar(int a, int b) {
        return a * b;
    }
}
````