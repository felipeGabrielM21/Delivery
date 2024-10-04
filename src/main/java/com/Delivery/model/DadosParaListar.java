package com.Delivery.model;

import java.math.BigDecimal;

public record DadosParaListar(int feijoada, int frango, int carne, int parmegiana, BigDecimal total) {

    public DadosParaListar(Pedido listarPedido) {
        this(listarPedido.getFeijoada(), listarPedido.getFrango(), listarPedido.getCarne(), listarPedido.getParmegiana(), listarPedido.getTotal());
    }
}
