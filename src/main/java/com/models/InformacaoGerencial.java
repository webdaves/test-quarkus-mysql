package com.models;

import com.enumeration.TipoInformacaoEnum;

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
public class InformacaoGerencial {
  private TipoInformacaoEnum tipoInfo;

  private String descricao;
}
