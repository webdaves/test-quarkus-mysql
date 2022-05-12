package com.parameters;

import com.enumeration.CategoriaEnum;
import com.models.Veiculo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoParameter {
  private String placa;

  private String categoria;

  public Veiculo toModel() {
    Veiculo veiculo = new Veiculo();
    veiculo.setPlaca(this.getPlaca());
    veiculo.setCategoria(
        this.getCategoria() != null && !this.getCategoria().isEmpty() ? CategoriaEnum.valueOf(this.getCategoria())
            : CategoriaEnum.MOTOCICLETA_MOTONETA_BICICLETA_A_MOTOR);
    return veiculo;
  }
}
