package com.Delivery.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int feijoada;
    int frango;
    int carne;
    int parmegiana;
    private BigDecimal total;

    public Pedido() {}

    public Pedido(DadosParaPedido dados) {
        this.feijoada = dados.feijoada();
        this.frango = dados.frango();
        this.carne = dados.carne();
        this.parmegiana = dados.parmegiana();
        this.total = dados.total();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFeijoada() {
        return feijoada;
    }

    public void setFeijoada(int feijoada) {
        this.feijoada = feijoada;
    }

    public int getFrango() {
        return frango;
    }

    public void setFrango(int frango) {
        this.frango = frango;
    }

    public int getCarne() {
        return carne;
    }

    public void setCarne(int carne) {
        this.carne = carne;
    }

    public int getParmegiana() {
        return parmegiana;
    }

    public void setParmegiana(int parmegiana) {
        this.parmegiana = parmegiana;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
