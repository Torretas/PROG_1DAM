package com.cursos.u6_ej2_api_cursos.model;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@JacksonXmlRootElement
@Entity
public class Curso {
    @Id
    private String nombre;
    private int duracion;
    private String horario;

    public Curso(String nombre, int duracion, String horario) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.horario = horario;
    }

    public Curso() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
