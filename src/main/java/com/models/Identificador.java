package com.models;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.enumeration.CategoriaEnum;
import com.enumeration.MotivoInativacaoEnum;
import com.enumeration.SituacaoIdentificadorEnum;
import com.enumeration.TipoVeiculoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.serializers.IdentificadorSerializer;
import com.serializers.InformacoesGerenciaisSerializer;
import com.serializers.VeiculoSerializer;

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

  @JsonProperty(value = "clienteConta")
  private ClienteConta clienteConta;

  @JsonProperty(value = "tipoIdentificador")
  private String tipoIdentificador;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
  private Date dataInclusao;

  private Veiculo veiculo;

  private SituacaoIdentificadorEnum situacao = SituacaoIdentificadorEnum.ATIVO;

  private MotivoInativacaoEnum motivoInativacao;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
  private Date dataAtualizacao;

  private Set<InformacaoGerencial> informacoesGerenciais;

  private String canal;

  private int pap;

  public IdentificadorSerializer toSerializer() {
    IdentificadorSerializer identificador = new IdentificadorSerializer();
    identificador.setIdIdentificador(this.getIdIdentificador());
    identificador.setSituacao(this.getSituacao());
    identificador.setCodIdentificador(this.getCodIdentificador());
    identificador.setPap(this.getPap());

    if (this.getVeiculo() != null) {
      VeiculoSerializer veiculo = new VeiculoSerializer();
      veiculo.setCategoria(Optional.ofNullable(this.getVeiculo()).map(Veiculo::getCategoria)
          .map(CategoriaEnum::getDescricao).orElse(null));
      veiculo.setPlaca(this.getVeiculo().getPlaca());
      veiculo.setTipo(Optional.ofNullable(this.getVeiculo()).map(Veiculo::getCategoria)
          .map(CategoriaEnum::getTipoVeiculo).map(TipoVeiculoEnum::getDescricao).orElse(null));
      identificador.setVeiculo(veiculo);
    }

    if (this.getInformacoesGerenciais() != null && !this.getInformacoesGerenciais().isEmpty()) {
      List<InformacoesGerenciaisSerializer> informacoesGerenciais = this.getInformacoesGerenciais()
          .stream().map(InformacoesGerenciaisSerializer::new)
          .collect(Collectors.toList());

      informacoesGerenciais.sort(Comparator.comparing(InformacoesGerenciaisSerializer::getTipoInfo));

      identificador.setInformacoesGerenciais(informacoesGerenciais);
    }

    return identificador;
  }
}
