package com.projetospringudemy.curso.servicos;

import com.projetospringudemy.curso.entidades.Usuario;
import com.projetospringudemy.curso.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServico {

    @Autowired
    private UsuarioRepositorio repositorio;

    public List<Usuario> findAll () {
        return repositorio.findAll();
    }
    public Usuario findById (Long id) {
        Optional<Usuario> obj = repositorio.findById(id);
        return obj.get();
    }
}
