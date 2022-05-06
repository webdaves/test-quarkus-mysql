package com.repository;

import java.util.List;

import com.models.Identificador;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface IdentificadorRepository extends PanacheRepository<Identificador> {

  public List<Identificador> listByIdConta(Integer idConta);

}
