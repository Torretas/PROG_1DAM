# Conceptos avanzados de Programación Orientada a Objetos (POO) en Java

## 📚 Índice
1. [Sobrecarga de Métodos](#sobrecarga-de-métodos)
2. [Clases Abstractas](#clases-abstractas)
3. [Interfaces](#interfaces)
4. [Polimorfismo](#polimorfismo)
5. [Composición](#composición)
6. [Clases Internas](#clases-internas)
7. [Clases y Métodos Genéricos](#clases-y-métodos-genéricos)
8. [Excepciones Personalizadas](#excepciones-personalizadas)

---

## Sobrecarga de Métodos
La **sobrecarga** ocurre cuando se definen múltiples métodos con el mismo nombre dentro de una clase, pero con diferentes parámetros (tipo, número, o ambos). Esto permite implementar variantes de un método según las necesidades.

> **Código de ejemplo: Sobrecarga de Métodos**
````java
class Calculadora {
    public int sumar(int a, int b) {
        return a + b;
    }

    public double sumar(double a, double b) {
        return a + b;
    }

    public int sumar(int a, int b, int c) {
        return a + b + c;
    }
}
````
---

## Clases Abstractas
Las **clases abstractas** son aquellas que no se pueden instanciar directamente. Sirven como base para otras clases y pueden contener métodos abstractos (sin implementación) y métodos concretos (con implementación).

> **Código de ejemplo: Clases Abstractas**
````java
abstract class Figura {
    protected String color;

    public Figura(String color) {
        this.color = color;
    }

    public abstract double calcularArea();

    public String getColor() {
        return color;
    }
}

class Circulo extends Figura {
    private double radio;

    public Circulo(String color, double radio) {
        super(color);
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}
````
---

## Interfaces
Una **interfaz** es un contrato que define un conjunto de métodos que una clase debe implementar. A partir de Java 8, las interfaces también pueden contener métodos con implementación predeterminada.

> **Código de ejemplo: Interfaces**
````java
interface Animal {
    void hacerSonido();
}

class Perro implements Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Guau Guau");
    }
}

class Gato implements Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Miau Miau");
    }
}
````
---

## Polimorfismo
El **polimorfismo** , como vimos anteriormente, permite que un objeto tome múltiples formas, es decir, que un mismo método pueda comportarse de manera diferente según el tipo del objeto que lo invoca.

> **Código de ejemplo: Polimorfismo**
````java
class Empleado {
    public void trabajar() {
        System.out.println("Trabajando...");
    }
}

class Programador extends Empleado {
    @Override
    public void trabajar() {
        System.out.println("Escribiendo código...");
    }
}

class Disenador extends Empleado {
    @Override
    public void trabajar() {
        System.out.println("Diseñando interfaces...");
    }
}
````
---

## Composición
La **composición** implica que una clase utilice instancias de otras clases como parte de su implementación. Esto permite construir clases complejas a partir de componentes más simples.

> **Código de ejemplo: Composición**
````java
class Motor {
    public void encender() {
        System.out.println("Motor encendido.");
    }
}

class Coche {
    private Motor motor;

    public Coche() {
        this.motor = new Motor();
    }

    public void arrancar() {
        motor.encender();
        System.out.println("El coche está en marcha.");
    }
}
````
---

## Clases Internas
Las **clases internas** están definidas dentro de otra clase y tienen acceso a todos los miembros de su clase externa, incluidos los privados.

> **Código de ejemplo: Clases Internas**
````java
class Externa {
    private String mensaje = "Hola desde la clase interna";

    class Interna {
        public void imprimirMensaje() {
            System.out.println(mensaje);
        }
    }
}
````
---

## Clases y Métodos Genéricos
Los **genéricos** permiten escribir clases y métodos que pueden operar con cualquier tipo de datos, asegurando al mismo tiempo la seguridad en tiempo de compilación.

> **Código de ejemplo: Clases y Métodos Genéricos**
````java
class Caja<T> {
    private T contenido;

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public T getContenido() {
        return contenido;
    }
}
````
---

## Excepciones Personalizadas
Las **excepciones personalizadas** permiten definir y manejar errores específicos a nivel de aplicación mediante la creación de nuevas clases de excepción.

> **Código de ejemplo: Excepciones Personalizadas**
````java
class MiExcepcion extends Exception {
    public MiExcepcion(String mensaje) {
        super(mensaje);
    }
}

public class PruebaExcepcion {
    public static void main(String[] args) {
        try {
            lanzarExcepcion();
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
        }
    }

    public static void lanzarExcepcion() throws MiExcepcion {
        throw new MiExcepcion("Esto es una excepción personalizada.");
    }
}
````

