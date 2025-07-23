package com.projetospringudemy.curso.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetospringudemy.curso.entidades.pk.PedidoItemPk;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "tabela_pedido_item")
public class PedidoItem implements Serializable {

    @EmbeddedId
    private PedidoItemPk id = new PedidoItemPk();

    private Integer quantidade;
    private Double preco;

    public PedidoItem(){
    }

    public PedidoItem(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
        super();
        id.setPedido(pedido);
        id.setProduto(produto);
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @JsonIgnore
    public Pedido getPedido() {
        return id.getPedido();
    }

    public void setPedido (Pedido pedido) {
        id.setPedido(pedido);
    }


    public Produto getproduto() {
        return id.getProduto();
    }

    public void setProduto (Produto produto) {
        id.setProduto(produto);
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PedidoItem pedido = (PedidoItem) obj;
        if (id == null) {
            if (pedido.id != null)
                return false;
        } else if (!id.equals(pedido.id))
            return false;
        return true;
    }
}
