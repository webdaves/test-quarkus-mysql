package com.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Identificador {
  @JsonProperty(value = "id")
  private String idIdentificador;

  @JsonProperty(value = "nuIdentificador")
  private Long nuIdentificador;

  @JsonProperty(value = "codIdentificador")
  private String codIdentificador;

  @JsonProperty(value = "idConta")
  private int idConta;

  @JsonProperty(value = "tipoIdentificador")
  private String tipoIdentificador;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
  private LocalDateTime dataInclusao;

  private String apelido;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
  private LocalDateTime dataAtualizacao;

  private Boolean pap;
}
