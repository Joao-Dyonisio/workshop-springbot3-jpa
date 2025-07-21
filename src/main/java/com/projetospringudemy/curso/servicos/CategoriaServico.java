package com.projetospringudemy.curso.servicos;

import com.projetospringudemy.curso.entidades.Categoria;
import com.projetospringudemy.curso.repositorios.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServico {

    @Autowired
    private CategoriaRepositorio repositorio;

    public List<Categoria> findAll () {
        return repositorio.findAll();
    }
    public Categoria findById (Long id) {
        Optional<Categoria> obj = repositorio.findById(id);
        return obj.get();
    }
}
