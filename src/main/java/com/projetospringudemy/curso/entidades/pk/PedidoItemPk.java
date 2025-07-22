package com.projetospringudemy.curso.entidades.pk;

import com.projetospringudemy.curso.entidades.Pedido;
import com.projetospringudemy.curso.entidades.Produto;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PedidoItemPk implements Serializable {

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PedidoItemPk that = (PedidoItemPk) o;
        return Objects.equals(pedido, that.pedido) && Objects.equals(produto, that.produto);
    }

    @Override
    public int hashCode() {
       final int prime = 31;
       int result = 1;
       result = prime * result + ((pedido == null ) ? 0 : pedido.hashCode());
       result = prime * result + ((produto == null ) ? 0 : produto.hashCode());
       return result;
    }
}
