# 🧪 Ejercicio CRUD básico con JDBC en Java

## 🎯 Objetivo

Crear una aplicación Java que permita realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre una tabla `usuarios` utilizando JDBC y el patrón DAO.

---

## 🧱 Requisitos previos

1. Tener un servidor MySQL o MariaDB activo.
2. Crear la base de datos y la tabla:
```sql
CREATE DATABASE crud_demo;

USE crud_demo;

CREATE TABLE usuarios (
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL UNIQUE
);
```
---

## 🗂️ Estructura del proyecto

src/  
├── model/  
│   └── Usuario.java  
├── dao/  
│   ├── UsuarioDAO.java  
│   └── UsuarioDAOImpl.java  
├── util/  
│   └── ConexionBD.java  
└── Main.java

---

## 📄 Clase `Usuario.java`
```java
package model;

public class Usuario {
private int id;
private String nombre;
private String email;

    public Usuario() {}

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public Usuario(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }

    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Usuario{id=" + id + ", nombre='" + nombre + "', email='" + email + "'}";
    }
}
```
---

## ⚙️ Clase `ConexionBD.java`
```java
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
private static final String URL = "jdbc:mysql://localhost:3306/crud_demo";
private static final String USER = "root";
private static final String PASSWORD = "tu_contraseña";

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
```
---

## 🧩 Interfaz `UsuarioDAO.java`
```java
package dao;

import model.Usuario;
import java.util.List;

public interface UsuarioDAO {
void crear(Usuario usuario);
List<Usuario> obtenerTodos();
void actualizar(Usuario usuario);
void eliminar(int id);
}
```
---

## 🧠 Clase `UsuarioDAOImpl.java`
```java
package dao;

import model.Usuario;
import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

    public void crear(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)";
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> obtenerTodos() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Connection conn = ConexionBD.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Usuario u = new Usuario(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("email")
                );
                lista.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void actualizar(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, email = ? WHERE id = ?";
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getEmail());
            stmt.setInt(3, usuario.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```
---

## 🚀 Clase `Main.java`

```java
import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import model.Usuario;

import java.util.Scanner;

public class Main {
public static void main(String[] args) {
UsuarioDAO dao = new UsuarioDAOImpl();
Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- CRUD de Usuarios ---");
            System.out.println("1. Crear usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            int op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    dao.crear(new Usuario(nombre, email));
                    break;
                case 2:
                    dao.obtenerTodos().forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("ID del usuario a actualizar: ");
                    int idUpd = Integer.parseInt(sc.nextLine());
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();
                    System.out.print("Nuevo email: ");
                    String nuevoEmail = sc.nextLine();
                    dao.actualizar(new Usuario(idUpd, nuevoNombre, nuevoEmail));
                    break;
                case 4:
                    System.out.print("ID del usuario a eliminar: ");
                    int idDel = Integer.parseInt(sc.nextLine());
                    dao.eliminar(idDel);
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
```

# 💡 Papel de JSON en un CRUD en Java

---

## 1. 📦 Intercambio de datos (cliente-servidor)

En aplicaciones web modernas, los datos que se envían desde el **frontend (Angular, React, etc.)** al **backend Java** suelen ir en formato **JSON**.

### Ejemplo

Un formulario envía al backend este objeto JSON:
```json
{
"nombre": "Ana Torres",
"email": "ana@example.com"
}
```
El backend en Java lo recibe, lo convierte a un objeto `Usuario`, lo guarda en la base de datos (operación **Create**) y responde con otro JSON.

---

## 2. 🧩 Serialización y deserialización en Java

En Java puedes usar bibliotecas como **Jackson** para convertir entre objetos y JSON (serializar/deserializar).

### Ejemplo con Jackson
```java
ObjectMapper mapper = new ObjectMapper();

String json = "{\"nombre\":\"Pedro\",\"email\":\"pedro@correo.com\"}";

Usuario usuario = mapper.readValue(json, Usuario.class);  // Deserializa JSON a objeto

String jsonGenerado = mapper.writeValueAsString(usuario);  // Serializa objeto a JSON
```
---

## 3. 💾 Persistencia alternativa con JSON

En lugar de usar una base de datos, puedes almacenar los datos de la aplicación en archivos `.json`. Esto permite:

- Prototipos o pruebas sin montar un SGBD.
- Persistencia básica sin instalación de MySQL.

### Ejemplo de archivo `usuarios.json`
```json
[
{
"id": 1,
"nombre": "Juan",
"email": "juan@mail.com"
},
{
"id": 2,
"nombre": "Lucía",
"email": "lucia@mail.com"
}
]
```
### Guardar un objeto Java en JSON
```java
ObjectMapper mapper = new ObjectMapper();
mapper.writeValue(new File("usuarios.json"), listaUsuarios);
```
### Leer desde JSON y cargar en lista
```java
List<Usuario> lista = mapper.readValue(new File("usuarios.json"),
new TypeReference<List<Usuario>>() {});
```
---

## 4. 🌐 JSON en APIs REST con Spring Boot

Cuando usas **Spring Boot**, los controladores REST reciben y devuelven datos en formato JSON.

### Ejemplo de endpoint REST
```java
@PostMapping("/usuarios")
public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
Usuario guardado = servicio.guardar(usuario);
return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
}
```
### Ejemplo de cuerpo de petición JSON
```json
{
"nombre": "Laura",
"email": "laura@example.com"
}
```
### Ejemplo de respuesta JSON
```json
{
"id": 23,
"nombre": "Laura",
"email": "laura@example.com"
}
```
---

## 🧠 Resumen

| Uso de JSON                      | Propósito                                                      |
|----------------------------------|----------------------------------------------------------------|
| **Intercambio de datos**         | Comunicación entre cliente (JavaScript) y servidor (Java)     |
| **Serialización en Java**        | Convertir objetos Java en JSON y viceversa                    |
| **Persistencia alternativa**     | Guardar datos en disco sin usar una base de datos relacional   |
| **API REST con Spring Boot**     | Entrada/salida de datos estructurados                         |

---
