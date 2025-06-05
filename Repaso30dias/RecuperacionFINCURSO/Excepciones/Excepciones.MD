*¿Qué es una excepción?*

Una excepción es un evento que interrumpe el flujo normal del programa cuando ocurre un error en tiempo de ejecución. Java proporciona un mecanismo para **capturar** y **gestionar errores** mediante **try, catch, finally, throw**

Tipos de excepciones:
    1. Comprobadas. `IOException`
    2. No comprobadas. Heredan de `RunTimeException`. Por ejemplo: `ArithmeticException`

Cómo crear excepciones personalizadas

```java
public class MiExcepcion extends Exception {
    public MiExcepcion(String mensaje) {
        super(mensaje);
    }
}
```
**Enunciado ejercicio: Aplicación que pida al usuario que introduzca una nota entre 0 y 10. La app debe lanzar:
    - Una excepcion estándar si el usuario introduce un dato no numérico
    - Una excepción personalizada (`NotaFueraRangoException`) si la nota está fuera del rango permitido**
