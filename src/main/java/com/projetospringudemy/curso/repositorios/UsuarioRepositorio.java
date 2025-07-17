package com.projetospringudemy.curso.repositorios;

import com.projetospringudemy.curso.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository <Usuario, Long> {
}
