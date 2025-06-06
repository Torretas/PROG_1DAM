package com.example.u6_ejer1_productos_api_rest.model;

import jakarta.persistence.*;

/*
* @Entity: marca la clase como entidad JPA
* @Table(name = "Productos"): especifica el nombre de la tabla en la BD
* @Id: marca el campo id como clave primaria
* @GeneratedValue(strategy= GenerationType.IDENTITY): configura la generación automática del ID
*
* */
@Entity
@Table(name = "Productos")
public class Producto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private double precio;

    public Producto(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
