package com.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.models.Identificador;
import com.repository.IdentificadorRepositoryImpl;

import io.agroal.api.AgroalDataSource;
import io.vertx.mutiny.mysqlclient.MySQLPool;

@ApplicationScoped
public class IdentificadoresService {

  private final IdentificadorRepositoryImpl identificadoresRepository;

  @Inject
  public IdentificadoresService(IdentificadorRepositoryImpl identificadoresRepository) {
    this.identificadoresRepository = identificadoresRepository;
  }

  @Inject
  MySQLPool client;

  @Inject
  AgroalDataSource defaultDataSource;

  public List<Identificador> getIdentificadores(String idConta) {
    var result = identificadoresRepository.listByIdConta(Integer.getInteger(idConta));

    return result;
  }

  public List<Identificador> getAllIdentificadores() {
    return identificadoresRepository.listAll();
  }
}
