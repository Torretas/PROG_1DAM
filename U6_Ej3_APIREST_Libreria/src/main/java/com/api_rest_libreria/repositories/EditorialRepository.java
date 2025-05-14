package com.api_rest_libreria.repositories;

import com.api_rest_libreria.models.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditorialRepository extends JpaRepository<Editorial, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
