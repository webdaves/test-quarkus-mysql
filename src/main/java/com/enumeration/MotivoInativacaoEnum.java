package com.enumeration;

/**
 * The Enum MotivoInativacao.
 * 
 * @author Franey Lima
 */
public enum MotivoInativacaoEnum {

  VEICULO_ROUBADO(1, "VEICULO ROUBADO"),

  TAG_EXTRAVIADO(4, "TAG_EXTRAVIADO"),

  TAG_SUSPEITA(2, "TAG SUSPEITA"),

  SEM_CONTRATO(3, "SEM CONTRATO");

  /** The codigo. */
  private int codigo;

  /** The descricao. */
  private String descricao;

  /**
   * Instantiates a new motivo inativacao.
   *
   * @param codigo
   *                  the codigo
   * @param descricao
   *                  the descricao
   */
  private MotivoInativacaoEnum(int codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  /**
   * From name.
   *
   * @param descricao
   *                  the descricao
   * @return the motivo inativacao
   */
  public static MotivoInativacaoEnum fromName(String descricao) {
    if (descricao != null) {
      for (MotivoInativacaoEnum motivoInativacao : MotivoInativacaoEnum.values()) {
        if (descricao.equals(motivoInativacao.getDescricao())) {
          return motivoInativacao;
        }
      }
      throw new IllegalArgumentException("Cannot create enum from " + descricao + " value!");
    }
    return null;
  }

  public static MotivoInativacaoEnum fromId(Integer id) {
    if (id != null) {
      for (MotivoInativacaoEnum motivoInativacao : MotivoInativacaoEnum.values()) {
        if (id == motivoInativacao.getCodigo()) {
          return motivoInativacao;
        }
      }
      throw new IllegalArgumentException("Cannot create enum from " + id + " value!");
    }
    return null;
  }

  /**
   * Gets the codigo.
   *
   * @return the codigo
   */
  public int getCodigo() {
    return codigo;
  }

  /**
   * Gets the descricao.
   *
   * @return the descricao
   */
  public String getDescricao() {
    return descricao;
  }

}
