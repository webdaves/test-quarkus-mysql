package com.parameters;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.models.Cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteParameter {
  @JsonProperty(value = "id")
  private String id;

  public Cliente toModel() {
    Cliente cliente = new Cliente();
    cliente.setId(this.id);
    return cliente;
  }
}
