package com.parameters;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.models.Conta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContaParameter {
  @JsonProperty(value = "id")
  private String id;

  @JsonProperty(value = "tipoProduto")
  private String tipoProduto;

  @JsonProperty(value = "utilizarLimite")
  private Boolean utilizarLimite;

  @JsonProperty(value = "limiteOperacional")
  private BigDecimal limiteOperacional;

  @JsonProperty(value = "diasCorte")
  private Integer diasCorte;

  public ContaParameter(String id) {
    this.id = id;
  }

  public Conta toModel() {
    Conta conta = new Conta();
    conta.setId(this.id);
    conta.setTipoProduto(this.tipoProduto);
    conta.setLimiteOperacional(this.limiteOperacional);
    conta.setUtilizarLimite(this.utilizarLimite);
    conta.setDiasCorte(this.diasCorte);
    return conta;
  }
}
