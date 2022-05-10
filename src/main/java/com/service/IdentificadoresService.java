package com.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.models.Identificador;
import com.repository.IdentificadorRepository;

import io.smallrye.mutiny.Multi;

@ApplicationScoped
public class IdentificadoresService {

  private final IdentificadorRepository identificadoresRepository;

  @Inject
  public IdentificadoresService(IdentificadorRepository identificadoresRepository) {
    this.identificadoresRepository = identificadoresRepository;
  }

  public Multi<Identificador> getIdentificadores(String idConta) {
    var result = identificadoresRepository.listByIdConta(Integer.parseInt(idConta));

    return result;
  }
}
