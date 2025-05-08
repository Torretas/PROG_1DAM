package com.cursos.u6_ej2_api_cursos.repository;

import com.cursos.u6_ej2_api_cursos.model.Curso;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CursoRepository extends CrudRepository<Curso, String> {

    //List<Curso> deleteByNombre(String nombre);
    // Esta interfaz proporciona los métodos automáticos de guardar, borrar, modificar y buscar (cursos)
}
