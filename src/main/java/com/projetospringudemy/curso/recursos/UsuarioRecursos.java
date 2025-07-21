package com.projetospringudemy.curso.recursos;

import com.projetospringudemy.curso.entidades.Usuario;
import com.projetospringudemy.curso.servicos.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecursos {

    @Autowired
    private UsuarioServico usuarioServico;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> lista = usuarioServico.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById( @PathVariable Long id) {
        Usuario obj = usuarioServico.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
