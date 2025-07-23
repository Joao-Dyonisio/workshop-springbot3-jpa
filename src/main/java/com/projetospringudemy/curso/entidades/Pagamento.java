package com.projetospringudemy.curso.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tabela_pagamento")
public class Pagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant momento;

    @OneToOne
    @MapsId
    private Pedido pedido;

    public Pagamento(){
    }

    public Pagamento(Long id, Pedido pedido, Instant momento) {
        super();
        this.id = id;
        this.pedido = pedido;
        this.momento = momento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pagamento pedido = (Pagamento) obj;
        if (id == null) {
            if (pedido.id != null)
                return false;
        } else if (!id.equals(pedido.id))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
