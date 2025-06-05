*Ejercicio 1. CuentaBancaria*

Crea una clase `CuentaBancaria` con atributos `numeroCuenta`, `saldo` y `titular`.
Incluye métodos para depositar y retirar dinero, así como un método que muestre el saldo actual.
Crea un main para probar la clase `PruebaCuentaBancaria`

*Ejercicio 2. Círculo y herencia*

Crea una clase `Figura` con un método `calcularArea`. Luego, crea una clase `Circulo` que herede de la clase anterior y sobreescriba el método para calcular el área de un círculo.
Para probar crea `PruebaFigura`

*Ejercicio 3. Empleado y polimorfismo*

Crea una clase `Empleado` con atributos `nombre` y `salario`. Crea un método llamado `calcularSalario`. Luego, genera una clase `EmpleadoPorHora` que herede de `Empleado` y sobreescriba el método `calcularSalario` para calcular el salario en función de las horas trabajadas y la tarifa por hora.
Prueba en `PruebaEmpleado`

 - Serializa una lista empleados para guardar un .dat con los datos del objeto creado en .java de prueba

*Ejercicio 4. Rectángulo e interfaces*

Crea una interfaz `Dibujable` con un método `dibujar`. Luego, crea una clase ´Rectangulo´ que implemente esa interfaz y defina el método.
Prueba en `PruebaDibujable`

Ejercicio 5. Ejercicio de Programación Orientada a Objetos con JSON

Crea una aplicación Java que permita gestionar distintos tipos de trabajadores: empleados por cuenta ajena y autónomos. La aplicación debe aplicar los pilares de la programación orientada a objetos (herencia, encapsulamiento, polimorfismo e interfaz) y persistir los datos en un fichero JSON.

Requisitos:

1. Herencia: crea una clase base Trabajador con atributos comunes y clases derivadas Empleado y Autonomo.

2. Encapsulamiento: atributos private con sus respectivos getters y setters.

3. Polimorfismo: método calcularIRPF() definido de forma distinta en cada subclase.

4. Interfaz: crea una interfaz Imprimible con el método mostrarResumen().

5. Persistencia: guarda y carga los datos desde un fichero JSON usando una librería como Jackson o Gson.

Funcionalidades mínimas:

Añadir trabajador

Listar trabajadores

Calcular IRPF

Guardar en JSON

Salir
