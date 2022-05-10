package com.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.models.Identificador;
import com.service.IdentificadoresService;

import io.smallrye.mutiny.Multi;

@Path("/identificadores")
public class IdentificadoresRest {

  private final IdentificadoresService service;

  @Inject
  public IdentificadoresRest(IdentificadoresService service) {
    this.service = service;
  }

  @GET
  @Path("/{idConta}")
  public Multi<Identificador> getIdentificadores(String idConta) {
    var identificadores = service.getIdentificadores(idConta);

    return identificadores;
  }
}
