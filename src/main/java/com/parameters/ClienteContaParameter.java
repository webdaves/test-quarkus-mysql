package com.parameters;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.models.ClienteConta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteContaParameter {
  @JsonProperty(value = "conta")
  private ContaParameter conta;

  @JsonProperty(value = "cliente")
  private ClienteParameter cliente;

  public ClienteContaParameter(String contaId, String clienteId) {
    this.conta = new ContaParameter(contaId);
    this.cliente = new ClienteParameter(clienteId);
  }

  public ClienteConta toModel() {

    ClienteConta clienteConta = new ClienteConta();
    clienteConta.setCliente(this.getCliente().toModel());
    clienteConta.setConta(this.getConta().toModel());

    return clienteConta;
  }
}
