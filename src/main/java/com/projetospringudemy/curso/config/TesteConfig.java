package com.projetospringudemy.curso.config;

import com.projetospringudemy.curso.entidades.*;
import com.projetospringudemy.curso.entidades.enums.PedidoStatus;
import com.projetospringudemy.curso.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    @Autowired
    private PedidoItemRepositorio pedidoItemRepositorio;

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Eletronicos");
        Categoria cat2 = new Categoria(null, "Livros");
        Categoria cat3 = new Categoria(null, "Computadores");

        Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoriaRepositorio.saveAll(Arrays.asList(cat1,cat2,cat3));
        produtoRepositorio.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        p1.getCategorias().add(cat2);
        p2.getCategorias().add(cat1);
        p2.getCategorias().add(cat3);
        p3.getCategorias().add(cat3);
        p4.getCategorias().add(cat3);
        p5.getCategorias().add(cat2);

        produtoRepositorio.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        Usuario u1 = new Usuario(null, "Maria", "maria@gmail.com", "957956879", "123");
        Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "98954343", "456");

        Pedido pedido1 = new Pedido(null, u1, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO);
        Pedido pedido2 = new Pedido(null, u2, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.AGURADANDO_PAGAMENTO);
        Pedido pedido3 = new Pedido(null, u1, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.ENTREGUE);

        usuarioRepositorio.saveAll(Arrays.asList(u1, u2));
        pedidoRepositorio.saveAll(Arrays.asList(pedido1,pedido2,pedido3));

        PedidoItem pedidoItem1 = new PedidoItem(pedido1, p1, 2, p1.getPreco());
        PedidoItem pedidoItem2 = new PedidoItem(pedido1, p3, 1, p3.getPreco());
        PedidoItem pedidoItem3 = new PedidoItem(pedido2, p3, 2, p3.getPreco());
        PedidoItem pedidoItem4 = new PedidoItem(pedido3, p5, 2, p5.getPreco());

        pedidoItemRepositorio.saveAll(Arrays.asList(pedidoItem1,pedidoItem2,pedidoItem3,pedidoItem4));

        Pagamento pagamento1 = new Pagamento(null, pedido1, Instant.parse("2019-06-20T21:53:07Z"));
        pedido1.setPagamento(pagamento1);

        pedidoRepositorio.save(pedido1);
    }
}
