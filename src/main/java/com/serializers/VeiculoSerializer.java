package com.serializers;

import com.models.Veiculo;

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
public class VeiculoSerializer {
  private String marca;

  private String modelo;

  private String placa;

  private String chassi;

  private String renavam;

  private String categoria;

  private String tipo;

  public VeiculoSerializer(Veiculo veiculo) {
    this.marca = veiculo.getMarca();
    this.modelo = veiculo.getModelo();
    this.placa = veiculo.getPlaca();
    this.chassi = veiculo.getChassi();
    this.renavam = veiculo.getRenavam();
    this.categoria = veiculo.getCategoria().getDescricao();
    this.tipo = veiculo.getTipo().name();
  }
}
