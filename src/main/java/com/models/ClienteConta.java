package com.models;

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
public class ClienteConta {
  @JsonProperty(value = "conta")
  private Conta conta;

  @JsonProperty(value = "cliente")
  private Cliente cliente;

  public ClienteConta(String contaId, String clienteId) {
    this.conta = new Conta(contaId);
    this.cliente = new Cliente(clienteId);
  }
}
