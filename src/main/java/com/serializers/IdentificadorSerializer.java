package com.serializers;

import java.time.LocalDateTime;
import java.util.List;

import com.enumeration.SituacaoIdentificadorEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
public class IdentificadorSerializer {
  private String idIdentificador;

  private String codIdentificador;

  @JsonProperty(value = "id-conta")
  private String idConta;

  @JsonProperty(value = "id-cliente")
  private String idCliente;

  private VeiculoSerializer veiculo;

  private List<InformacoesGerenciaisSerializer> informacoesGerenciais;

  private SituacaoIdentificadorEnum situacao;

  private String tipoIdentificador;

  @JsonSerialize(using = JsonDateTimeSerializer.class)
  private LocalDateTime dataAtualizacao;

  private int pap;
}
