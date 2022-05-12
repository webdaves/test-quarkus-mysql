package com.parameters;

import java.util.Objects;

import javax.ws.rs.core.MultivaluedMap;

import com.enumeration.OrdenacaoEnum;
import com.enumeration.TipoIdentificadorEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.models.Identificador;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IdentificadorParameter {

  private static final String PAGINA = "pagina";

  private static final String QUANTIDADE = "quantidade";

  private static final String APP = "APP";

  private static final String PORTAL = "PORTAL";

  private static final String WEB = "WEB";

  private static final String ATENDIMENTO = "ATENDIMENTO";

  private static final String TELEFONE_CRC = "TELEFONE CRC";

  private static final String URA = "URA";

  private static final String SN = "SN";

  private String idIdentificador;

  private String codIdentificador;

  private ClienteContaParameter clienteConta;

  private String tipoIdentificador;

  private VeiculoParameter veiculo;

  private String canal;

  private boolean gerencial;

  private PaginacaoParameter paginacao;

  private OrdenacaoEnum ordenacao = OrdenacaoEnum.SITUACAO;

  private boolean somentePlacas;

  private Boolean ativos;

  public IdentificadorParameter() {
    super();
  }

  public IdentificadorParameter(Integer idConta, MultivaluedMap<String, String> parameters) {
    this.clienteConta = new ClienteContaParameter(String.valueOf(idConta), null);

    Integer pagina = 1;
    Integer quantidade = 20;

    if (parameters != null) {
      if (!StringUtils.isEmpty(parameters.getFirst("placa"))) {
        VeiculoParameter veiculo = new VeiculoParameter();
        veiculo.setPlaca(parameters.getFirst("placa"));
        this.veiculo = veiculo;
      }

      if (!StringUtils.isEmpty(parameters.getFirst("identificador"))) {
        this.codIdentificador = parameters.getFirst("identificador");
      }

      this.gerencial = Boolean.valueOf(parameters.getFirst("gerencial"));

      if (!StringUtils.isEmpty(parameters.getFirst(PAGINA))) {
        pagina = NumberUtils.toInt(parameters.getFirst(PAGINA));
      }

      if (!StringUtils.isEmpty(parameters.getFirst(QUANTIDADE))) {
        quantidade = NumberUtils.toInt(parameters.getFirst(QUANTIDADE));
      }

      this.paginacao = new PaginacaoParameter(pagina, quantidade);

      if (!StringUtils.isEmpty(parameters.getFirst("ordenacao"))) {
        this.ordenacao = OrdenacaoEnum.getByName(parameters.getFirst("ordenacao"));
      }

      this.somentePlacas = Boolean.valueOf(parameters.getFirst("somentePlacas"));

      if (!StringUtils.isEmpty(parameters.getFirst("ativos"))) {
        this.ativos = Boolean.valueOf(parameters.getFirst("ativos"));
      }
    } else {
      this.paginacao = new PaginacaoParameter(pagina, quantidade);
    }
  }

  public String getIdIdentificador() {
    return idIdentificador;
  }

  public void setIdIdentificador(String idIdentificador) {
    this.idIdentificador = idIdentificador;
  }

  public String getCodIdentificador() {
    return codIdentificador;
  }

  public void setCodIdentificador(String codIdentificador) {
    this.codIdentificador = codIdentificador;
  }

  public ClienteContaParameter getClienteConta() {
    return clienteConta;
  }

  public void setClienteConta(ClienteContaParameter clienteConta) {
    this.clienteConta = clienteConta;
  }

  public String getTipoIdentificador() {
    return tipoIdentificador;
  }

  public void setTipoIdentificador(String tipoIdentificador) {
    this.tipoIdentificador = tipoIdentificador;
  }

  public VeiculoParameter getVeiculo() {
    return veiculo;
  }

  public void setVeiculo(VeiculoParameter veiculo) {
    this.veiculo = veiculo;
  }

  public boolean isGerencial() {
    return gerencial;
  }

  public void setGerencial(boolean gerencial) {
    this.gerencial = gerencial;
  }

  public PaginacaoParameter getPaginacao() {
    return paginacao;
  }

  public void setPaginacao(PaginacaoParameter paginacao) {
    this.paginacao = paginacao;
  }

  public String getCanal() {
    if (canal == null) {
      canal = WEB;
    } else if (canal.equalsIgnoreCase(APP)) {
      canal = canal.toUpperCase();
    } else if (canal.equalsIgnoreCase(PORTAL)) {
      canal = canal.toUpperCase();
    } else if (canal.equalsIgnoreCase(ATENDIMENTO)) {
      canal = canal.toUpperCase();
    } else if (canal.equalsIgnoreCase(TELEFONE_CRC)) {
      canal = canal.toUpperCase();
    } else if (canal.equalsIgnoreCase(URA)) {
      canal = canal.toUpperCase();
    } else if (canal.equalsIgnoreCase(SN)) {
      canal = canal.toUpperCase();
    } else {
      canal = WEB;
    }
    return canal;
  }

  public void setCanal(String canal) {
    this.canal = canal;
  }

  public OrdenacaoEnum getOrdenacao() {
    return ordenacao;
  }

  public void setOrdenacao(OrdenacaoEnum ordenacao) {
    this.ordenacao = ordenacao;
  }

  public boolean isSomentePlacas() {
    return somentePlacas;
  }

  public void setSomentePlacas(boolean somentePlacas) {
    this.somentePlacas = somentePlacas;
  }

  public Boolean getAtivos() {
    return ativos;
  }

  public void setAtivos(Boolean ativos) {
    this.ativos = ativos;
  }

  public Identificador toModel() {
    Identificador identificador = new Identificador();

    identificador.setIdIdentificador(this.getIdIdentificador());
    identificador.setCodIdentificador(this.getCodIdentificador());
    ClienteContaParameter clienteConta = new ClienteContaParameter(this.getClienteConta().getConta(),
        new ClienteParameter(this.getClienteConta().getCliente().getId()));
    identificador.setClienteConta(clienteConta.toModel());
    identificador.setTipoIdentificador(this.getTipoIdentificador());

    if (validarVeiculo(this.tipoIdentificador)) {
      identificador.setVeiculo(this.getVeiculo() != null ? this.getVeiculo().toModel() : null);
    }

    identificador.setCanal(this.getCanal());

    return identificador;
  }

  public Boolean validarVeiculo(String tipoIdentificador) {
    Boolean isValidarVeiculo = Boolean.TRUE;

    if (Objects.nonNull(tipoIdentificador) && (tipoIdentificador.equals(TipoIdentificadorEnum.BAND.name())
        || tipoIdentificador.equals(TipoIdentificadorEnum.SMART_BAND.name()))) {
      isValidarVeiculo = Boolean.FALSE;
    }

    return isValidarVeiculo;
  }
}
