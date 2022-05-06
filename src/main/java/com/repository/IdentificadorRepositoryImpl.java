package com.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.models.Identificador;

@ApplicationScoped
public class IdentificadorRepositoryImpl implements IdentificadorRepository {

  @Override
  public List<Identificador> listByIdConta(Integer idConta) {
    return list("idConta", idConta);
  }

}
