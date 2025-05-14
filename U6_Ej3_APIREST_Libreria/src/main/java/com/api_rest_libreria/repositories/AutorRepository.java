package com.api_rest_libreria.repositories;

import com.api_rest_libreria.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
