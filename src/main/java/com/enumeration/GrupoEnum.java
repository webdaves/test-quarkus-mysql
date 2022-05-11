package com.enumeration;

public enum GrupoEnum {

  PADRAO(0, "Padrão"),
  PAP(1, "PAP"),
  ISENTO(2, "ISENTO"),
  ISENTO_ARTESP(3, "ISENTO_ARTESP"),
  TARIFA_DIFERENCIADA(4, "TARIFA_DIFERENCIADA");

  private Integer codigo;

  private String descricao;

  GrupoEnum(Integer codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public Integer getCodigo() {
    return codigo;
  }

  public String getDescricao() {
    return descricao;
  }

  public static GrupoEnum getPorCodigo(Integer codigo) {
    for (GrupoEnum grupoEnum : GrupoEnum.values()) {
      if (grupoEnum.getCodigo() == codigo) {
        return grupoEnum;
      }
    }
    return null;
  }
}