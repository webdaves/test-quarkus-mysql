package com.repository;

import com.models.Identificador;
import com.parameters.IdentificadorParameter;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public interface IdentificadorRepository {

  public Multi<Identificador> listByIdConta(Integer idConta);

  public Multi<Identificador> listPaginadoByIdConta(Integer idConta,
      IdentificadorParameter parameters);

  public Uni<Integer> contarIdentificadores(Integer idConta, IdentificadorParameter parameters);

}
