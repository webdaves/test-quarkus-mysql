package com.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.StreamSupport;

import com.enumeration.CategoriaEnum;
import com.enumeration.OrdenacaoEnum;
import com.enumeration.SituacaoIdentificadorEnum;
import com.enumeration.TipoInformacaoEnum;
import com.models.Identificador;
import com.models.InformacaoGerencial;
import com.models.Veiculo;
import com.parameters.IdentificadorParameter;

import org.apache.commons.lang3.StringUtils;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.mysqlclient.MySQLPool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.RowSet;
import io.vertx.mutiny.sqlclient.Tuple;

@ApplicationScoped
public class IdentificadorRepositoryImpl implements IdentificadorRepository {

  @Inject
  MySQLPool client;

  private static final String PLACA = "placa";
  private static final String COD_IDENTIFICADOR = "codIdentificador";

  @Override
  public Multi<Identificador> listByIdConta(Integer idConta) {
    boolean gerencial = true;
    boolean somentePlacas = false;
    final StringBuilder query = getDefaultQuery(gerencial, somentePlacas);

    orderByIdentificador(query, OrdenacaoEnum.SITUACAO);
    query.append(", ").append(OrdenacaoEnum.PLACA.getColuna()).append(" ");

    return consultarIdentificadores(idConta, query, gerencial, somentePlacas);
  }

  @Override
  public Multi<Identificador> listPaginadoByIdConta(Integer idConta,
      IdentificadorParameter parameters) {
    final StringBuilder query = getDefaultQuery(parameters.isGerencial(), false);

    condicoesIdentificador(query, parameters);

    orderByIdentificador(query, OrdenacaoEnum.SITUACAO);
    query.append(", ").append(OrdenacaoEnum.PLACA.getColuna()).append(" ");

    paginacaoIdentificador(query, parameters);

    return consultarIdentificadores(idConta, query, parameters.isGerencial(),
        parameters.isSomentePlacas());
  }

  @Override
  public Uni<Integer> contarIdentificadores(Integer idConta, IdentificadorParameter parameters) {
    StringBuilder queryPaginacao = getQuantidadeQuery(parameters);
    var result = executeQuery(idConta, queryPaginacao, parameters.isGerencial());
    var qtd = result.onItem().transform(rowSet -> {
      var row = rowSet.iterator().next();
      return row.getInteger("qtdIdentificadores");
    });

    return qtd;
  }

  private Multi<Identificador> consultarIdentificadores(Integer idConta, final StringBuilder query, boolean gerencial,
      boolean somentePlacas) {
    var result = executeQuery(idConta, query, gerencial);
    Map<String, Identificador> mapIdentificadores = new LinkedHashMap<>();

    var mapped = result.onItem().transformToMulti(rs -> Multi.createFrom()
        .items(() -> StreamSupport.stream(rs.spliterator(), false)))
        .map(row -> {
          String key = somentePlacas ? row.getString(PLACA) : row.getString(COD_IDENTIFICADOR);
          if (!mapIdentificadores.containsKey(key)) {
            Identificador identificador = construirIdentificador(gerencial, somentePlacas, row);
            mapIdentificadores.put(key, identificador);
            return identificador;
          }
          construirInformacoesGerenciais(row, mapIdentificadores.get(key).getInformacoesGerenciais(),
              gerencial);
          return null;
        }).filter(identificador -> identificador != null);

    return mapped;
  }

  private Identificador construirIdentificador(boolean gerencial, boolean somentePlacas, Row row) {
    if (somentePlacas) {
      return construirIdentificadorSomentePlacas(row);
    } else {
      return construirIdentificador(row, gerencial);
    }
  }

  private Identificador construirIdentificadorSomentePlacas(Row row) {

    Identificador identificador = new Identificador();

    Veiculo veiculo = new Veiculo();
    veiculo.setPlaca(row.getString(PLACA));
    identificador.setVeiculo(veiculo);
    identificador.setSituacao(null);

    return identificador;
  }

  private Identificador construirIdentificador(Row row, boolean gerencial) {

    Identificador identificador = new Identificador();

    identificador.setIdIdentificador(row.getString("id"));
    identificador.setCodIdentificador(row.getString(COD_IDENTIFICADOR));
    identificador.setSituacao(SituacaoIdentificadorEnum.valueOf(row.getString("situacao")));
    identificador.setPap(row.getInteger("pap") == null ? 0 : row.getInteger("pap"));
    String placa = row.getString(PLACA);

    if (Objects.nonNull(placa) && !placa.isEmpty() && row.getString("categoria") != null) {
      Veiculo veiculo = new Veiculo();
      veiculo.setPlaca(placa);
      veiculo.setCategoria(CategoriaEnum.valueOf(row.getString("categoria")));

      identificador.setVeiculo(veiculo);

    }

    Set<InformacaoGerencial> infoGerenciais = new HashSet<>();

    construirInformacoesGerenciais(row, infoGerenciais, gerencial);

    identificador.setInformacoesGerenciais(infoGerenciais);

    return identificador;
  }

  private void construirInformacoesGerenciais(Row row, Set<InformacaoGerencial> infoGerenciais,
      boolean gerencial) {
    if (gerencial && Objects.nonNull(row.getString("tipoInformacao"))) {
      InformacaoGerencial informacao = new InformacaoGerencial();

      informacao.setTipoInfo(TipoInformacaoEnum.valueOf(row.getString("tipoInformacao")));

      informacao.setDescricao(row.getString("descricao"));

      infoGerenciais.add(informacao);
    }
  }

  private Uni<RowSet<Row>> executeQuery(Integer idConta, final StringBuilder query, boolean gerencial) {
    Tuple tuple;

    if (gerencial) {
      tuple = Tuple.of(Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()), idConta);
    } else {
      tuple = Tuple.of(idConta);
    }

    return this.client
        .preparedQuery(query.toString())
        .execute(tuple);
  }

  private StringBuilder getDefaultQuery(boolean gerencial, boolean somentePlacas) {

    StringBuilder query = new StringBuilder();

    buildSelectQuery(gerencial, somentePlacas, query);
    buildFromQuery(gerencial, query);
    buildWhereQuery(query);

    return query;
  }

  private void buildSelectQuery(boolean gerencial, boolean somentePlacas, StringBuilder query) {
    query.append("SELECT DISTINCT");
    if (somentePlacas) {
      query.append("   idf.placa ");
    } else {
      query.append("   idf.id,");
      query.append("   idf.codIdentificador, ");
      query.append("   idf.placa, ");
      query.append("   idf.situacao, ");
      query.append("   idf.pap, ");
      if (gerencial) {
        query.append("   ig.inicioVigencia, ");
        query.append("   ig.terminoVigencia, ");
        query.append("   ig.tipoInformacao, ");
        query.append("   ig.descricao, ");
      }
      query.append("   iv.categoria ");
    }
  }

  private void buildFromQuery(boolean gerencial, StringBuilder query) {
    query.append(" FROM ");
    query.append("   stage.Identificador idf ");
    query.append("   LEFT JOIN");
    query.append("      stage.IdentificadorVeiculo as iv ");
    query.append("      on (idf.id = iv.identificador_id) ");
    if (gerencial) {
      query.append("   LEFT JOIN");
      query.append("	  stage.InformacaoGerencialIdentificador as ig");
      query.append("      on (ig.conta = idf.idConta and ig.placa = idf.placa");
      query.append("   		AND ig.inicioVigencia <= ?");
      query.append("   		AND (ig.terminoVigencia is null ");
      query.append("				OR ig.terminoVigencia >= ? )");
      query.append("			)");
    }
  }

  private void buildWhereQuery(StringBuilder query) {
    query.append(" WHERE");
    query.append("   idf.idConta = ? ");
  }

  private void orderByIdentificador(StringBuilder query, OrdenacaoEnum ordenacao) {
    query.append(" ORDER BY ").append(ordenacao.getColuna()).append(" ");
  }

  private void condicoesIdentificador(StringBuilder query, IdentificadorParameter parameter) {

    if (parameter.getVeiculo() != null && !StringUtils.isEmpty(parameter.getVeiculo().getPlaca())) {
      if (!StringUtils.isEmpty(parameter.getCodIdentificador())) {
        query.append(" AND ( ");
        query.append(" idf.placa like '").append(parameter.getVeiculo().getPlaca()).append("%'");
        query.append(" OR idf.codIdentificador like '").append(parameter.getCodIdentificador()).append("%'");
        query.append(" ) ");
      } else {
        query.append(" AND idf.placa like '").append(parameter.getVeiculo().getPlaca()).append("%'");
      }
    } else if (!StringUtils.isEmpty(parameter.getCodIdentificador())) {
      query.append(" AND idf.codIdentificador like '").append(parameter.getCodIdentificador()).append("%'");
    }

    if (parameter.getAtivos() != null) {
      query.append(" AND idf.situacao = '").append(parameter.getAtivos().booleanValue() ? "ATIVO" : "INATIVO")
          .append("' ");
    }

  }

  private void paginacaoIdentificador(StringBuilder query, IdentificadorParameter parameter) {
    int pagina = parameter.getPaginacao().getPagina();
    int quantidade = parameter.getPaginacao().getQuantidade();
    int min = pagina == 1 ? 0 : quantidade * (pagina - 1);

    query.append(" LIMIT ").append(min).append(", ").append(quantidade);

    query.append(";");
  }

  private StringBuilder getQuantidadeQuery(IdentificadorParameter parameter) {
    StringBuilder query = new StringBuilder();
    if (parameter.isSomentePlacas()) {
      query.append(" SELECT count(DISTINCT idf.placa) as qtdIdentificadores ");
    } else {
      query.append(" SELECT count(1) as qtdIdentificadores ");
    }
    buildFromQuery(parameter.isGerencial(), query);
    buildWhereQuery(query);
    condicoesIdentificador(query, parameter);
    return query;
  }
}
