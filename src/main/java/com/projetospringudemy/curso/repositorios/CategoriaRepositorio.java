package com.projetospringudemy.curso.repositorios;

import com.projetospringudemy.curso.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository <Categoria, Long> {
}
