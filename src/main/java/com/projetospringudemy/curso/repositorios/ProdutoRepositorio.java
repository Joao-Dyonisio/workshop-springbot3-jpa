package com.projetospringudemy.curso.repositorios;

import com.projetospringudemy.curso.entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositorio extends JpaRepository <Produto, Long> {
}
