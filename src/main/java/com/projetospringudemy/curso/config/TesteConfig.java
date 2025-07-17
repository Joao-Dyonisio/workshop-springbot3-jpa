package com.projetospringudemy.curso.config;

import com.projetospringudemy.curso.entidades.Usuario;
import com.projetospringudemy.curso.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public void run(String... args) throws Exception {

        Usuario u1 = new Usuario(null, "123", "123455641", "Maria", "maria@gmail.com");
        Usuario u2 = new Usuario(null, "456", "123456789", "Alex Green", "alex@gmail.com");

        usuarioRepositorio.saveAll(Arrays.asList(u1, u2));
    }
}
