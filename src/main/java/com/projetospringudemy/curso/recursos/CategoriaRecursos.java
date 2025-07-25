package com.projetospringudemy.curso.recursos;

import com.projetospringudemy.curso.entidades.Categoria;
import com.projetospringudemy.curso.servicos.CategoriaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaRecursos {

    @Autowired
    private CategoriaServico categoriaServico;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        List<Categoria> lista = categoriaServico.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById( @PathVariable Long id) {
        Categoria obj = categoriaServico.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
