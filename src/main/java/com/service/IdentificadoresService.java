package com.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.repository.IdentificadorRepository;
import com.serializers.IdentificadorSerializer;

import io.smallrye.mutiny.Multi;

@ApplicationScoped
public class IdentificadoresService {

  private final IdentificadorRepository identificadoresRepository;

  @Inject
  public IdentificadoresService(IdentificadorRepository identificadoresRepository) {
    this.identificadoresRepository = identificadoresRepository;
  }

  public Multi<IdentificadorSerializer> getIdentificadores(String idConta) {
    var result = identificadoresRepository.listByIdConta(Integer.parseInt(idConta));

    var serializad = result.map(identificador -> identificador.toSerializer());

    return serializad;
  }
}
