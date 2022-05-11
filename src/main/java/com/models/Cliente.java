package com.models;

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
public class Cliente {
  private String id;
  private String customerId;
  private String nomeFantasia;
  private String razaoSocial;
  private String cnpj;
  private String nome;
  private String cpf;
  private Contato contato;
  private Contato contatoAdministrador;

  public Cliente(String id) {
    this.id = id;
  }
}
