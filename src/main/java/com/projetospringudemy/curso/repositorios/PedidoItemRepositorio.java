package com.projetospringudemy.curso.repositorios;

import com.projetospringudemy.curso.entidades.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItemRepositorio extends JpaRepository <PedidoItem, Long> {
}
