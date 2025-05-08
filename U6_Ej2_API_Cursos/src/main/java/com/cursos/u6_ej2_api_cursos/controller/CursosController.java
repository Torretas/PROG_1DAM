package com.cursos.u6_ej2_api_cursos.controller;

import com.cursos.u6_ej2_api_cursos.model.Curso;
import com.cursos.u6_ej2_api_cursos.repository.CursoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CursosController {

    // Atributo del controlador como una lista de cursos
    private List<Curso> cursos;


    /*Anotación que me asegura que justo cuando
    se instancie el controlador se ejecute el metodo init*/
    @PostConstruct
    public void init() {
        // Creamos el arraylist de cursos aunque lo ideal es acceder a estos datos de una bbdd
        cursos = new ArrayList<>();
        cursos.add(new Curso("1DAM", 1000, "mañana"));
        cursos.add(new Curso("2DAM", 1000, "mañana"));
        cursos.add(new Curso("1SMR", 1000, "tarde"));
        cursos.add(new Curso("1DAW", 1000, "tarde"));
        cursos.add(new Curso("1ASIR", 1000, "telemático"));
    }

    // 2º recurso o metodo del ejercicio 4. URL->cursos
    @GetMapping(value="cursos", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> getCursos() {
        return cursos;
    }

    // 1er recurso. Genera un curso. URL->curso
    @GetMapping(value="curso", produces= MediaType.APPLICATION_JSON_VALUE)
    public Curso getCurso() {
        return new Curso("2DAM", 1000, "mañana");

        /* Ya se encargará la librería Jackson de mapear un objeto a un JSON
        Lo hará cuando se reciba una petición GET cuya URL sea "curso" y
        que requiere un tipo de respuesta en formato JSON
         */
    }

    // 3er recurso. Buscador de cursos. Devuelve los cursos de un determinado nombre. URL cursos con variable
    @GetMapping(value="cursos/{name}", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> buscarCursos(@PathVariable("name") String nombre) {
        List<Curso> aux = new ArrayList<>();
        for (Curso curso : cursos) {
            if (curso.getNombre().contains(nombre)) {
                aux.add(curso);
            }
        }
        return aux;
    }

    // Operación de BORRADO - DELETE
    @DeleteMapping(value="curso/{name}")
    public void eliminarCurso(@PathVariable("name") String nombre) {
        cursos.removeIf(curso -> curso.getNombre().equals(nombre));
    }

    // Operación de CREACIÓN - POST
    @PostMapping(value="curso", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE) // consumes es el tipo de dato que recibe y produces el tipo de dato que devuelve
    public List<Curso> crearCurso(@RequestBody Curso curso) {
        cursos.add(curso);
        return cursos;
    }

    // Operación de ACTUALIZACIÓN - PUT
    @PutMapping(value="curso", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> actualizarCurso(@RequestBody Curso curso) {

        // actualiza los datos del curso que tenga el mismo nombre
        for (int i=0; i<cursos.size(); i++) {
            if (cursos.get(i).getNombre().equals(curso.getNombre())) {
                cursos.set(i, curso);
            }
        }
        return cursos;
    }

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping(value="cursos", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> getCursosRepo() {
        return (List<Curso>) cursoRepository.findAll();
    }

    /*@GetMapping(value="cursos/{name}", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> buscarCursosRepo(@PathVariable("name") String nombre) {
        return cursoRepository.findAll().
    }*/

    @PostMapping(value="curso", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE) // consumes es el tipo de dato que recibe y produces el tipo de dato que devuelve
    public Curso crearCursoRepo(@RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }

    // El siguiente metodo igual a la anterior?. No.
    /*
    * Si la clave primaria no existe, inserta un nuevo registro (CREATE)
    * Si la clave primaria ya existe, actualiza el registro existente (UPDATE)
    *
    * Lo suyo aquí es validar en el POST para asegurar que no existe el recurso
    * Y en el PUT asegurarte de que el recurso exista antes de actualizarlo
    * */
    @PutMapping(value="curso", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public Curso actualizarCursoRepo(@RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }

    @DeleteMapping(value="curso/{name}")
    public void eliminarCursoRepo(@PathVariable("name") String nombre) {
        cursoRepository.deleteById(nombre);
    }




}
