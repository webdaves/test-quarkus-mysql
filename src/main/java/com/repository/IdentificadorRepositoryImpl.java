package com.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import java.util.stream.StreamSupport;

import com.models.Identificador;

import io.smallrye.mutiny.Multi;
import io.vertx.mutiny.mysqlclient.MySQLPool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.Tuple;

@ApplicationScoped
public class IdentificadorRepositoryImpl implements IdentificadorRepository {

  @Inject
  MySQLPool client;

  @Override
  public Multi<Identificador> listByIdConta(Integer idConta) {
    return this.client
        .preparedQuery("SELECT * FROM stage.Identificador i WHERE i.idConta = ?")
        .execute(Tuple.of(idConta))
        .onItem()
        .transformToMulti(rs -> Multi.createFrom()
            .items(() -> StreamSupport.stream(rs.spliterator(), false)))
        .map(IdentificadorRepositoryImpl::populateIdentificador);
  }

  private static Identificador populateIdentificador(Row row) {
    var identificador = new Identificador(
        row.getString("id"),
        row.getLong("nuIdentificador"),
        row.getString("codIdentificador"),
        row.getInteger("idConta"),
        row.getString("tipoIdentificador"),
        row.getLocalDateTime("dataInclusao"),
        row.getString("apelido"),
        row.getLocalDateTime("dataAtualizacao"),
        row.getBoolean("pap"));

    return identificador;
  }

}
