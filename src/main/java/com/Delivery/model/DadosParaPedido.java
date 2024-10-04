package com.Delivery.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosParaPedido(

        Integer feijoada,

      Integer frango,

      Integer carne,

      Integer parmegiana,

      @NotNull
      BigDecimal total) {

}


