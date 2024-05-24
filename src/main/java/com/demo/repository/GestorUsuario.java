package com.demo.repository;

import com.demo.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("gestor")
public interface GestorUsuario extends JpaRepository<Usuario, Serializable> {
    public abstract Usuario findByUsuario(String usuario);
}
