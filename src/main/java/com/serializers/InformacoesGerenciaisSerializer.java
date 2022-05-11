package com.serializers;

import com.enumeration.TipoInformacaoEnum;
import com.models.InformacaoGerencial;

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
public class InformacoesGerenciaisSerializer {
  private TipoInformacaoEnum tipoInfo;

  private String descricaoAtual;

  public InformacoesGerenciaisSerializer(InformacaoGerencial informacaoGerencial) {
    this.tipoInfo = informacaoGerencial.getTipoInfo();
    this.descricaoAtual = informacaoGerencial.getDescricao();
  }
}
