package com.api_rest_libreria.controllers;

import com.api_rest_libreria.models.Autor;
import com.api_rest_libreria.models.Libro;
import com.api_rest_libreria.repositories.AutorRepository;
import com.api_rest_libreria.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {
    @Autowired
    private AutorRepository autorRepo;

    @Autowired
    private LibroRepository libroRepo;

    @GetMapping
    public List<Autor> obtenerAutores() {
        return autorRepo.findAll();
    }

    @GetMapping("/{id}")
    public Autor obtenerAutor(@PathVariable Long id) {
        return autorRepo.findById(id).orElseThrow();
    }

    @PostMapping
    public Autor crearAutor(@RequestBody Autor autor) {
        return autorRepo.save(autor);
    }

    @PutMapping("/{id}")
    public Autor actualizarAutor(@PathVariable Long id, @RequestBody Autor nuevoAutor) {
        Autor autor = autorRepo.findById(id).orElseThrow();
        autor.setNombre(nuevoAutor.getNombre());
        autor.setApellido(nuevoAutor.getApellido());
        autor.setEmail(nuevoAutor.getEmail());
        return autorRepo.save(autor);
    }

    @DeleteMapping("/{id}")
    public void eliminarAutor(@PathVariable Long id) {
        autorRepo.deleteById(id);
    }

    @GetMapping("/{id}/libros")
    public List<Libro> obtenerLibrosPorAutor(@PathVariable Long id) {
        return libroRepo.findByAutorId(id);
    }
}
