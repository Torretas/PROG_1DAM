# ¿Qué es CRUD?

**CRUD** es un acrónimo que representa las cuatro operaciones básicas y fundamentales que se realizan sobre datos almacenados de forma persistente (normalmente en una base de datos):

## Operaciones CRUD

- **Create (Crear):** Añadir nuevos registros o datos.
    - *Ejemplo:* Registrar un nuevo usuario en el sistema, añadir un nuevo producto al catálogo.
    - *SQL equivalente:* INSERT

- **Read (Leer/Recuperar):** Consultar o buscar datos existentes. Puede ser un registro específico o un conjunto de ellos.
    - *Ejemplo:* Obtener los datos de un usuario por su ID, mostrar todos los productos de una categoría, buscar clientes por nombre.
    - *SQL equivalente:* SELECT

- **Update (Actualizar):** Modificar registros o datos existentes.
    - *Ejemplo:* Cambiar la dirección de correo electrónico de un usuario, actualizar el stock de un producto.
    - *SQL equivalente:* UPDATE

- **Delete (Borrar):** Eliminar registros o datos existentes.
    - *Ejemplo:* Eliminar la cuenta de un usuario, quitar un producto descatalogado.
    - *SQL equivalente:* DELETE

Estas cuatro operaciones son la base de la mayoría de las aplicaciones que manejan información, desde una simple agenda de contactos hasta complejos sistemas de gestión empresarial.

---

# CRUD en Aplicaciones Java

En Java, la implementación de operaciones CRUD generalmente implica interactuar con una base de datos. Existen varias tecnologías y patrones para lograr esto:

## JDBC (Java Database Connectivity)

- Es la API fundamental de Java para conectarse e interactuar con bases de datos relacionales (como MySQL, PostgreSQL, Oracle, etc.).
- Permite establecer una conexión, enviar sentencias SQL (INSERT, SELECT, UPDATE, DELETE) y procesar resultados.
- **Uso en CRUD:** Se escriben sentencias SQL directamente y se ejecutan con objetos Statement o PreparedStatement.

**Ventajas:**
- Control total sobre el SQL.

**Desventajas:**
- Muy verboso (mucho código repetitivo para abrir/cerrar conexiones, manejar excepciones, mapear resultados manualmente).

---

## Patrón DAO (Data Access Object)

- Patrón de diseño para encapsular el acceso a los datos.
- Se crea una interfaz (por ejemplo, UsuarioDAO) que define métodos CRUD (crearUsuario, obtenerUsuarioPorId, actualizarUsuario, eliminarUsuario).
- Se implementa esa interfaz (por ejemplo, UsuarioDAOImpl) usando JDBC o JPA.

**Ventajas:**
- Separa la lógica de acceso a datos del resto de la aplicación.
- Código más limpio, organizado y mantenible.

---

## JPA (Java Persistence API) y ORMs como Hibernate

- JPA es una especificación estándar de Java para la persistencia. Hibernate es la implementación más popular.
- ORM: Permiten mapear objetos Java directamente a tablas de la base de datos.

### Cómo se usa para CRUD:

**Create:**
``java
entityManager.persist(nuevoUsuario);
``
**Read:**
``java
Usuario usuario = entityManager.find(Usuario.class, id);
``
**Update:**
``java
usuario.setEmail("nuevo@email.com");
``
**Delete:**
``java
entityManager.remove(usuario);
``
**Ventajas:**
- Reduce enormemente el código repetitivo (boilerplate).
- Trabajas de forma más orientada a objetos.
- Abstrae diferencias entre bases de datos.

**Desventajas:**
- Puede tener una curva de aprendizaje inicial.
- Requiere configuración y entender el funcionamiento del ORM para optimizar.

---

## Spring Framework y Spring Data JPA

- Spring (especialmente Spring Boot) simplifica enormemente el desarrollo de aplicaciones Java.
- Spring Data JPA lleva la simplificación de JPA un paso más allá.

### Ejemplo conceptual:

import org.springframework.data.jpa.repository.JpaRepository;
``java
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
// Spring Data JPA te proporciona automáticamente métodos como:
// save(Usuario usuario)         -> Create y Update
// findById(Long id)             -> Read (por ID)
// findAll()                     -> Read (todos)
// deleteById(Long id)           -> Delete
// Puedes añadir métodos personalizados como:
// List<Usuario> findByNombre(String nombre);
}
``
**Ventajas:**
- Máxima productividad.
- Se escribe muy poco código para operaciones CRUD estándar.
- Se integra perfectamente con el ecosistema Spring (transacciones, inyección de dependencias, etc.).

---

## En Resumen

| Tecnología / Patrón        | Nivel        | Ventajas                                       | Desventajas                                 |
|---------------------------|--------------|------------------------------------------------|---------------------------------------------|
| **JDBC**                  | Bajo          | Control total sobre el SQL                     | Muy verboso, requiere mucho código manual   |
| **DAO Pattern**           | Medio         | Organiza el código de acceso a datos           | Implementación extra                        |
| **JPA / Hibernate**       | Alto (ORM)    | Menos código, más OO, abstracción de BD        | Configuración, curva de aprendizaje         |
| **Spring Data JPA**       | Muy alto      | CRUD casi sin escribir código, integración     | Menor control directo sobre las consultas   |

En proyectos modernos con Java, se tiende a utilizar **JPA/Hibernate** junto con **Spring Data JPA** debido a su simplicidad y productividad. Sin embargo, entender JDBC sigue siendo fundamental para comprender los fundamentos del acceso a datos.
