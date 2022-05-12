package com.enumeration;

import java.util.Arrays;

public enum OrdenacaoEnum {
  PLACA("idf.placa"),
  SITUACAO("idf.situacao"),
  DATA_INCLUSAO("idf.dataInclusao");

  private String coluna;

  private OrdenacaoEnum(String coluna) {
    this.coluna = coluna;
  }

  public String getColuna() {
    return this.coluna;
  }

  public static OrdenacaoEnum getByName(final String name) {
    return Arrays.stream(OrdenacaoEnum.values())
        .filter(ordenacao -> ordenacao.name().equals(name.toUpperCase()))
        .findFirst().orElse(null);
  }
}
