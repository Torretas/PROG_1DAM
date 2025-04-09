# Métodos y Funciones en Java

## 📚 Índice
1. [¿Qué es un Método?](#qué-es-un-método)
2. [Sintaxis de un Método en Java](#sintaxis-de-un-método-en-java)
3. [Tipos de Métodos en Java](#tipos-de-métodos-en-java)
4. [Modificadores de Acceso](#modificadores-de-acceso)
5. [Métodos `static`](#métodos-static)
6. [Ejemplos Prácticos](#ejemplos-prácticos)

---

### ¿Qué es un Método?
Un método en Java es un bloque de código que realiza una tarea específica. Los métodos permiten estructurar el código en partes reutilizables y modulares. Usamos métodos para evitar la duplicación de código y para facilitar su mantenimiento.

### Sintaxis de un Método en Java
La estructura básica de un método en Java es la siguiente:

```java
public [tipo] nombreMetodo([parametros]) {
    // cuerpo del método
    // código que realiza una tarea
    return [valor]; // si el tipo es diferente de void
}
```
- **public**: Modificador de acceso (explicado más adelante).
- **tipo**: El tipo de dato que devuelve el método (o void si no devuelve nada).
- **nombreMetodo**: Nombre del método, en formato camelCase.
- **parametros**: Datos de entrada opcionales que el método recibe y usa dentro de su código.

Ejemplo Básico:
```java

public int sumar(int a, int b) {
    int resultado = a + b;
    return resultado;
}
```

### Tipos de Métodos en Java
1. Métodos void
Los métodos void no devuelven ningún valor. Se usan para realizar una acción, como mostrar un mensaje o modificar un objeto.

```java

public void mostrarMensaje() {
    System.out.println("¡Hola, bienvenido a Java!");
}
```

2. Métodos que devuelven un valor
Estos métodos devuelven un valor específico, como un número o una cadena. Es necesario utilizar return para devolver el valor.

```java
public double calcularArea(double radio) {
    return Math.PI * radio * radio;
}
```

### Modificadores de Acceso
Los modificadores de acceso controlan la visibilidad del método desde otras clases. Los modificadores más comunes son:

- **public**: El método es accesible desde cualquier clase.
- **private**: Solo se puede acceder al método dentro de la misma clase.
- **protected**: El método es accesible en la misma clase, en subclases y en el mismo paquete.
- **default** (sin especificar modificador): Solo es accesible dentro del mismo paquete.

Ejemplo de Modificadores de Acceso
```java
public class Persona {
    private String nombre;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
```

### Métodos static.
Los métodos static pertenecen a la clase y no a una instancia de la clase. Esto significa que pueden llamarse sin necesidad de crear un objeto. Se utilizan principalmente para definir funciones de utilidad.

Ejemplo de Método static:
```java
public class Utilidades {
    public static int sumar(int a, int b) {
        return a + b;
    }
}

// Llamada al método sin crear un objeto de `Utilidades`
int resultado = Utilidades.sumar(5, 10);
```

### Ejemplos Prácticos

1. Método con Parámetros y Retorno. Este método calcula el área de un rectángulo:

````java
public double calcularAreaRectangulo(double ancho, double alto) {
    return ancho * alto;
}
````

2. Método void sin Parámetros. Este método imprime un mensaje de bienvenida:

````java
public void mostrarBienvenida() {
    System.out.println("¡Bienvenido al programa!");
}
````
3. Método static para Calcular el Factorial de un Número. Este método calcula el factorial de un número entero:

````java
public static int factorial(int n) {
    int resultado = 1;
    for (int i = 1; i <= n; i++) {
        resultado *= i;
    }
    return resultado;
}
````

**Resumen de Conceptos Clave**

- Modularización: Los métodos permiten dividir el código en partes más pequeñas y reutilizables.
- Modificadores de Acceso: Controlan la visibilidad de los métodos (public, private, protected).
- Métodos static: Pertenecen a la clase y pueden llamarse sin instanciar objetos.
- Parámetros y Retorno: Los métodos pueden aceptar parámetros y devolver valores para ser más versátiles y útiles.