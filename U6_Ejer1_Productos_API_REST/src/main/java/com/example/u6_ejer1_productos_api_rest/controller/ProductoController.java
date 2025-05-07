package com.example.u6_ejer1_productos_api_rest.controller;

import com.example.u6_ejer1_productos_api_rest.model.Producto;
import com.example.u6_ejer1_productos_api_rest.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping()
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    private List<Producto> productos = new ArrayList<>();
    private int idCounter = 0;

    public ProductoController() {
        // Añadimos algunos productos de ejemplos
        productos.add(new Producto(idCounter++, "PortatilOscar", 1080));
        productos.add(new Producto(idCounter++, "TabletJavi", 800));
        productos.add(new Producto(idCounter++, "AuricularesEster", 100));

    }

    @GetMapping("/productos")
    public List<Producto> obtenerProductos() {
        return productos;
    }

    // Adaptación tras emplear Spring Data JPA
    @GetMapping
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    @PostMapping("/producto")
    public Producto crearProducto(@RequestBody Producto producto) {
        producto.setId(idCounter++);
        productos.add(producto);
        return producto;
    }

    // Adaptación del metodo de crearProducto
    @PostMapping
    public Producto crearProducto2(@RequestBody Producto producto) {
        Producto nuevoProducto = productoRepository.save(producto);
        return nuevoProducto;
    }

    /*
    * @RequestBody capturar el cuerpo de una petición HTTP y lo convierte en un objeto Java
    * @PathVariable captura una parte (dato-variable) de la URL (en este caso un ID)
    *
    * */
    @PutMapping("/producto/{id}")
    public Producto actualizarProducto(@RequestBody Producto productoActualizado, @PathVariable int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                producto.setNombre(productoActualizado.getNombre());
                producto.setPrecio(productoActualizado.getPrecio());
                return producto;
            }
        }
        return null;
    }

    // Adaptación del metodo actualizarProducto
    @PutMapping("/{id}")
    public Producto actualizarProducto2(@PathVariable Integer id, @RequestBody Producto productoActualizado) {

        productoActualizado.setId(id);
        productoActualizado.setPrecio(productoActualizado.getPrecio());
        return productoRepository.save(productoActualizado);

    }

    @DeleteMapping("/producto/{id}")
    public void eliminarProducto(@PathVariable int id) {
        productos.removeIf(producto -> producto.getId() == id);
    }

    // Adaptación Delete
    @DeleteMapping("/{id}")
    public void eliminarProducto2(@PathVariable Integer id) {
        productoRepository.deleteById(id);
    }

}
