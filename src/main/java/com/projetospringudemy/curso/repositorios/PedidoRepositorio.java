package com.projetospringudemy.curso.repositorios;

import com.projetospringudemy.curso.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositorio extends JpaRepository <Pedido, Long> {
}
