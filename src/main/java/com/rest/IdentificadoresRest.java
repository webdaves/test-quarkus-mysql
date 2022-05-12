package com.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import com.serializers.IdentificadorSerializer;
import com.serializers.IdentificadorSerializerPaginadoSerializer;
import com.service.IdentificadoresService;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

@Path("/identificadores")
public class IdentificadoresRest {

  private final IdentificadoresService service;

  @Inject
  public IdentificadoresRest(IdentificadoresService service) {
    this.service = service;
  }

  @GET
  @Path("/{idConta}")
  public Multi<IdentificadorSerializer> getIdentificadores(Integer idConta) {
    var identificadores = service.getIdentificadores(idConta);

    return identificadores;
  }

  @GET
  @Path("/{idConta}/paginado")
  public Uni<IdentificadorSerializerPaginadoSerializer> getIdentificadoresPaginado(@Context UriInfo info,
      Integer idConta) {
    var queryParams = info.getQueryParameters();
    var identificadores = service.getIdentificadoresPaginado(idConta, queryParams);

    return identificadores;
  }
}
