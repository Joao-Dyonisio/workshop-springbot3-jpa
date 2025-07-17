package com.projetospringudemy.curso.recursos;

import com.projetospringudemy.curso.entidades.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecursos {

    @GetMapping
    public ResponseEntity<Usuario> findAll() {
        Usuario usuario = new Usuario(1L, "123", "31231331", "Maria", "Maria@gmail.com");
        return ResponseEntity.ok().body(usuario);
    }
}
