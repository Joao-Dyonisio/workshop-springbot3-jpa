package com.projetospringudemy.curso.servicos;

import com.projetospringudemy.curso.entidades.Produto;
import com.projetospringudemy.curso.repositorios.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServico {

    @Autowired
    private ProdutoRepositorio repositorio;

    public List<Produto> findAll () {
        return repositorio.findAll();
    }
    public Produto findById (Long id) {
        Optional<Produto> obj = repositorio.findById(id);
        return obj.get();
    }
}
