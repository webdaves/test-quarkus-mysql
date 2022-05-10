package com.repository;

import com.models.Identificador;

import io.smallrye.mutiny.Multi;

public interface IdentificadorRepository {

  public Multi<Identificador> listByIdConta(Integer idConta);

}
