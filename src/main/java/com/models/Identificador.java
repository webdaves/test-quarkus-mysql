package com.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Identificador")
public class Identificador {

  public Identificador() {

  }

  public Identificador(String idIdentificador) {
    this.idIdentificador = idIdentificador;
  }

  @Id
  @JsonProperty(value = "id")
  @Column(name = "id")
  private String idIdentificador;

  @JsonProperty(value = "nuIdentificador")
  private Long nuIdentificador;

  @JsonProperty(value = "codIdentificador")
  private String codIdentificador;

  @JsonProperty(value = "idConta")
  private int idConta;

  // @JsonProperty(value = "clienteConta")
  // private ClienteConta clienteConta;

  @JsonProperty(value = "tipoIdentificador")
  private String tipoIdentificador;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
  private Date dataInclusao;

  // private Veiculo veiculo;

  private String apelido;

  // private SituacaoIdentificadorEnum situacao = SituacaoIdentificadorEnum.ATIVO;

  // private MotivoInativacaoEnum motivoInativacao;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
  private Date dataAtualizacao;

  // private Set<InformacaoGerencial> informacoesGerenciais;

  // private String canal;

  private Boolean pap;

  public String getIdIdentificador() {
    return idIdentificador;
  }

  public void setIdIdentificador(String idIdentificador) {
    this.idIdentificador = idIdentificador;
  }

  public Long getNuIdentificador() {
    return nuIdentificador;
  }

  public void setNuIdentificador(Long nuIdentificador) {
    this.nuIdentificador = nuIdentificador;
  }

  public String getCodIdentificador() {
    return codIdentificador;
  }

  public void setCodIdentificador(String codIdentificador) {
    this.codIdentificador = codIdentificador;
  }

  public int getIdConta() {
    return idConta;
  }

  public void setIdConta(int idConta) {
    this.idConta = idConta;
  }

  // public ClienteConta getClienteConta() {
  // return clienteConta;
  // }

  public String getTipoIdentificador() {
    return tipoIdentificador;
  }

  public void setTipoIdentificador(String tipoIdentificador) {
    this.tipoIdentificador = tipoIdentificador;
  }

  // public void setClienteConta(ClienteConta clienteConta) {
  // this.clienteConta = clienteConta;
  // }

  // public Veiculo getVeiculo() {
  // return veiculo;
  // }

  // public void setVeiculo(Veiculo veiculo) {
  // this.veiculo = veiculo;
  // }

  public String getApelido() {
    return apelido;
  }

  public void setApelido(String apelido) {
    this.apelido = apelido;
  }

  // public SituacaoIdentificadorEnum getSituacao() {
  // return situacao;
  // }

  // public void setSituacao(SituacaoIdentificadorEnum situacao) {
  // this.situacao = situacao;
  // }

  // public MotivoInativacaoEnum getMotivoInativacao() {
  // return motivoInativacao;
  // }

  // public void setMotivoInativacao(MotivoInativacaoEnum motivoInativacao) {
  // this.motivoInativacao = motivoInativacao;
  // }

  public Date getDataInclusao() {
    return dataInclusao;
  }

  public void setDataInclusao(Date dataInclusao) {
    this.dataInclusao = dataInclusao;
  }

  public Date getDataAtualizacao() {
    return dataAtualizacao;
  }

  public void setDataAtualizacao(Date dataAtualizacao) {
    this.dataAtualizacao = dataAtualizacao;
  }

  // public Set<InformacaoGerencial> getInformacoesGerenciais() {
  // return informacoesGerenciais;
  // }

  // public void setInformacoesGerenciais(Set<InformacaoGerencial>
  // informacoesGerenciais) {
  // this.informacoesGerenciais = informacoesGerenciais;
  // }

  // public String getCanal() {
  //   return canal;
  // }

  // public void setCanal(String canal) {
  //   this.canal = canal;
  // }

  public Boolean getPap() {
    return pap;
  }

  public void setPap(Boolean pap) {
    this.pap = pap;
  }
}
