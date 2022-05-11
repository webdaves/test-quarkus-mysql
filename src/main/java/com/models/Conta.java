package com.models;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
public class Conta {
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

  public Conta(String id) {
    this.id = id;
  }
}
