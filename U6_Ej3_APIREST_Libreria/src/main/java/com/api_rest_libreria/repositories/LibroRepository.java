package com.api_rest_libreria.repositories;

import com.api_rest_libreria.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario como:

    List<Libro> findByAutorId(Long autorId);
    List<Libro> findByEditorialId(Long editorialId);
}
