package com.enumeration;

import java.util.Arrays;

public enum TipoVeiculoEnum {

  CARRO(0, "Carro"),
  MOTO(1, "Moto"),
  CAMINHAO(2, "Caminhão"),
  ONIBUS(3, "Ônibus");

  private Integer id;

  private String descricao;

  private TipoVeiculoEnum(Integer id, String descricao) {
    this.id = id;
    this.descricao = descricao;
  }

  public Integer getId() {
    return id;
  }

  public static TipoVeiculoEnum getById(Integer id) {
    return Arrays.stream(TipoVeiculoEnum.values())
        .filter(cat -> cat.getId().equals(id))
        .findFirst().orElse(null);
  }

  public String getDescricao() {
    return descricao;
  }

}