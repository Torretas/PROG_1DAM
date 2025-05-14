package com.api_rest_libreria.controllers;

import com.api_rest_libreria.models.Editorial;
import com.api_rest_libreria.models.Libro;
import com.api_rest_libreria.repositories.EditorialRepository;
import com.api_rest_libreria.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/editoriales")
public class EditorialController {
    @Autowired
    private EditorialRepository editorialRepo;

    @Autowired
    private LibroRepository libroRepo;

    @GetMapping
    public List<Editorial> obtenerEditoriales() {
        return editorialRepo.findAll();
    }

    @GetMapping("/{id}")
    public Editorial obtenerEditorial(@PathVariable Long id) {
        return editorialRepo.findById(id).orElseThrow();
    }

    @PostMapping
    public Editorial crearEditorial(@RequestBody Editorial editorial) {
        return editorialRepo.save(editorial);
    }

    @PutMapping("/{id}")
    public Editorial actualizarEditorial(@PathVariable Long id, @RequestBody Editorial nuevaEditorial) {
        Editorial editorial = editorialRepo.findById(id).orElseThrow();
        editorial.setNombre(nuevaEditorial.getNombre());
        editorial.setDireccion(nuevaEditorial.getDireccion());
        return editorialRepo.save(editorial);
    }

    @DeleteMapping("/{id}")
    public void eliminarEditorial(@PathVariable Long id) {
        editorialRepo.deleteById(id);
    }

    @GetMapping("/{id}/libros")
    public List<Libro> obtenerLibrosPorEditorial(@PathVariable Long id) {
        return libroRepo.findByEditorialId(id);
    }
}
