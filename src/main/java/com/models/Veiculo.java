package com.models;

import com.enumeration.CategoriaEnum;
import com.enumeration.GrupoEnum;
import com.enumeration.TipoVeiculoEnum;
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
public class Veiculo {
  private String marca;

  private String modelo;

  private String placa;

  private String chassi;

  private String renavam;

  private CategoriaEnum categoria;

  private Boolean categoriaValidada;

  private String categoriaDescricao;

  private GrupoEnum grupo;

  private String grupoDescricao;

  @JsonProperty("tipo")
  public TipoVeiculoEnum getTipo() {
    if (this.categoria == null)
      return null;
    return this.categoria.getTipoVeiculo();
  }
}
