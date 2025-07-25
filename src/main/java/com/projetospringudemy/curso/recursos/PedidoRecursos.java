package com.projetospringudemy.curso.recursos;

import com.projetospringudemy.curso.entidades.Pedido;
import com.projetospringudemy.curso.servicos.PedidoServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoRecursos {

    @Autowired
    private PedidoServico pedidoServico;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> lista = pedidoServico.findAll();
        return ResponseEntity.ok().body(lista);    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id) {
        Pedido obj = pedidoServico.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
