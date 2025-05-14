package com.api_rest_libreria.controllers;

import com.api_rest_libreria.models.Libro;
import com.api_rest_libreria.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {
    @Autowired
    private LibroRepository libroRepo;

    @GetMapping
    public List<Libro> obtenerLibros() {
        return libroRepo.findAll();
    }

    @GetMapping("/{id}")
    public Libro obtenerLibro(@PathVariable Long id) {
        return libroRepo.findById(id).orElseThrow();
    }

    @PostMapping
    public Libro crearLibro(@RequestBody Libro libro) {
        return libroRepo.save(libro);
    }

    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable Long id, @RequestBody Libro nuevoLibro) {
        Libro libro = libroRepo.findById(id).orElseThrow();
        libro.setTitulo(nuevoLibro.getTitulo());
        libro.setAnioPublicacion(nuevoLibro.getAnioPublicacion());
        libro.setAutor(nuevoLibro.getAutor());
        libro.setEditorial(nuevoLibro.getEditorial());
        return libroRepo.save(libro);
    }

    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        libroRepo.deleteById(id);
    }
}

