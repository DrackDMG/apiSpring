package com.demo.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="ID" , unique=true)
    private long id;
    @Column(name="USUARIO",unique=true)
    private String usuario;
    @Column(name="CONTRASENA")
    private String contrasena;
    @Column(name="ROL")
    private Byte rol;



    @Column(name="ACTIVO")
    private boolean activo;

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Byte getRol() {
        return rol;
    }

    public void setRol(Byte rol) {
        this.rol = rol;
    }

}
