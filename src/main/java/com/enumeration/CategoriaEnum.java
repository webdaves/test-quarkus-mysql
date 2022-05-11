package com.enumeration;

import java.util.Arrays;

public enum CategoriaEnum {

  DOIS_EIXOS_RODAGEM_SIMPLES(1, "2 eixos, rodagem simples", 0),
  DOIS_EIXOS_RODAGEM_DUPLA(2, "2 eixos, rodagem dupla", 2),
  TRES_EIXOS_RODAGEM_DUPLA(3, "3 eixos, rodagem dupla", 2),
  QUATRO_EIXOS_RODAGEM_DUPLA(4, "4 eixos, rodagem dupla", 2),
  CINCO_EIXOS_RODAGEM_DUPLA(5, "5 eixos, rodagem dupla", 2),
  SEIS_EIXOS_RODAGEM_DUPLA(6, "6 eixos, rodagem dupla", 2),
  TRES_EIXOS_RODAGEM_SIMPLES(7, "3 eixos, rodagem simples", 2),
  QUATRO_EIXOS_RODAGEM_SIMPLES(8, "4 eixos, rodagem simples", 2),
  MOTOCICLETA_MOTONETA_BICICLETA_A_MOTOR(9, "Motocicleta, Motoneta e Bicicleta a motor", 1),
  ONIBUS_DOIS_EIXOS(12, "Ônibus (2 eixos)", 3),
  ONIBUS_TRES_EIXOS(14, "Ônibus (3 eixos)", 3),
  ONIBUS_QUATRO_EIXOS(15, "Ônibus (4 eixos)", 3),
  SETE_EIXOS_RODAGEM_DUPLA(61, "7 eixos, rodagem dupla", 2),
  OITO_EIXOS_RODAGEM_DUPLA(62, "8 eixos, rodagem dupla", 2),
  NOVE_EIXOS_RODAGEM_DUPLA(63, "9 eixos, rodagem dupla", 2),
  DEZ_EIXOS_RODAGEM_DUPLA(64, "10 eixos, rodagem dupla", 2),
  ONZE_EIXOS_RODAGEM_DUPLA(65, "11 eixos, rodagem dupla", 2),
  DOZE_EIXOS_RODAGEM_DUPLA(66, "12 eixos, rodagem dupla", 2),
  TREZE_EIXOS_RODAGEM_DUPLA(67, "13 eixos, rodagem dupla", 2),
  CATORZE_EIXOS_RODAGEM_DUPLA(68, "14 eixos, rodagem dupla", 2),
  QUINZE_EIXOS_RODAGEM_DUPLA(69, "15 eixos, rodagem dupla", 2),
  DEZESSEIS_EIXOS_RODAGEM_DUPLA(16, "16 eixos, rodagem dupla", 2),
  DEZESSETE_EIXOS_RODAGEM_DUPLA(17, "17 eixos, rodagem dupla", 2),
  DEZOITO_EIXOS_RODAGEM_DUPLA(18, "18 eixos, rodagem dupla", 2),
  DEZENOVE_EIXOS_RODAGEM_DUPLA(19, "19 eixos, rodagem dupla", 2),
  VINTE_EIXOS_RODAGEM_DUPLA(20, "20 eixos, rodagem dupla", 2),
  VINTE_E_UM_EIXOS_RODAGEM_DUPLA(21, "21 eixos, rodagem dupla", 2),
  VINTE_E_DOIS_EIXOS_RODAGEM_DUPLA(22, "22 eixos, rodagem dupla", 2),
  VINTE_E_TRES_EIXOS_RODAGEM_DUPLA(23, "23 eixos, rodagem dupla", 2),
  VINTE_E_QUATRO_EIXOS_RODAGEM_DUPLA(24, "24 eixos, rodagem dupla", 2),
  VINTE_E_CINCO_EIXOS_RODAGEM_DUPLA(25, "25 eixos, rodagem dupla", 2),
  VINTE_E_SEIS_EIXOS_RODAGEM_DUPLA(26, "26 eixos, rodagem dupla", 2),
  VINTE_E_SETE_EIXOS_RODAGEM_DUPLA(27, "27 eixos, rodagem dupla", 2),
  VINTE_E_OITO_EIXOS_RODAGEM_DUPLA(28, "28 eixos, rodagem dupla", 2),
  VINTE_E_NOVE_EIXOS_RODAGEM_DUPLA(29, "29 eixos, rodagem dupla", 2),
  TRINTA_EIXOS_RODAGEM_DUPLA(30, "30 eixos, rodagem dupla", 2),
  TRINTA_E_UM_EIXOS_RODAGEM_DUPLA(31, "31 eixos, rodagem dupla", 2),
  TRINTA_E_DOIS_EIXOS_RODAGEM_DUPLA(32, "32 eixos, rodagem dupla", 2),
  TRINTA_E_TRES_EIXOS_RODAGEM_DUPLA(33, "33 eixos, rodagem dupla", 2),
  TRINTA_E_QUATRO_EIXOS_RODAGEM_DUPLA(34, "34 eixos, rodagem dupla", 2),
  TRINTA_E_CINCO_EIXOS_RODAGEM_DUPLA(35, "35 eixos, rodagem dupla", 2),
  TRINTA_E_SEIS_EIXOS_RODAGEM_DUPLA(36, "36 eixos, rodagem dupla", 2),
  TRINTA_E_SETE_EIXOS_RODAGEM_DUPLA(37, "37 eixos, rodagem dupla", 2),
  TRINTA_E_OITO_EIXOS_RODAGEM_DUPLA(38, "38 eixos, rodagem dupla", 2),
  TRINTA_E_NOVE_EIXOS_RODAGEM_DUPLA(39, "39 eixos, rodagem dupla", 2),
  QUARENTA_EIXOS_RODAGEM_DUPLA(40, "40 eixos, rodagem dupla", 2),
  QUARENTA_E_UM_EIXOS_RODAGEM_DUPLA(41, "41 eixos, rodagem dupla", 2),
  QUARENTA_E_DOIS_EIXOS_RODAGEM_DUPLA(42, "42 eixos, rodagem dupla", 2),
  QUARENTA_E_TRES_EIXOS_RODAGEM_DUPLA(43, "43 eixos, rodagem dupla", 2),
  QUARENTA_E_QUATRO_EIXOS_RODAGEM_DUPLA(44, "44 eixos, rodagem dupla", 2),
  QUARENTA_E_CINCO_EIXOS_RODAGEM_DUPLA(45, "45 eixos, rodagem dupla", 2),
  QUARENTA_E_SEIS_EIXOS_RODAGEM_DUPLA(46, "46 eixos, rodagem dupla", 2),
  QUARENTA_E_SETE_EIXOS_RODAGEM_DUPLA(47, "47 eixos, rodagem dupla", 2),
  QUARENTA_E_OITO_EIXOS_RODAGEM_DUPLA(48, "48 eixos, rodagem dupla", 2);

  private Integer id;

  private String descricao;

  private TipoVeiculoEnum tipoVeiculo;

  CategoriaEnum(Integer id, String descricao, Integer categoria) {
    this.id = id;
    this.descricao = descricao;
    this.tipoVeiculo = TipoVeiculoEnum.getById(categoria);
  }

  public Integer getId() {
    return this.id;
  }

  public String getDescricao() {
    return descricao;
  }

  public TipoVeiculoEnum getTipoVeiculo() {
    return tipoVeiculo;
  }

  public static CategoriaEnum getByDescricao(String descricao) {
    return Arrays.stream(CategoriaEnum.values())
        .filter(cat -> cat.getDescricao().equals(descricao))
        .findFirst().orElse(null);
  }

  public static CategoriaEnum getEnum(String name) {
    try {
      return CategoriaEnum.valueOf(name);
    } catch (Exception e) {
      return null;
    }
  }

}