package com.demo.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="nota")
public class Nota implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="ID_NOTA")
    private long id;
    @Column(name="NOMBRE")
    private String nombre;
    @Column(name="TITULO")
    private String titulo;
    @Column(name="CONTENIDO")
    private String contenido;

public Nota() {
    }

    public Nota(long id, String nombre, String titulo, String contenido) {
        this.id = id;
        this.nombre = nombre;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
