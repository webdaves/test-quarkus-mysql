package com.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.service.IdentificadoresService;

@Path("/identificadores")
public class IdentificadoresRest {

  private final IdentificadoresService service;

  // public Identificadores() {
  // service = new IdentificadoresService();
  // }

  @Inject
  public IdentificadoresRest(IdentificadoresService service) {
    this.service = service;
  }

  @GET
  @Path("/{idConta}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getIdentificadores(String idConta) {
    var identificadores = service.getIdentificadores(idConta);

    return Response.ok(identificadores).build();
  }

  @GET
  @Path("/list")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllIdentificadores() {
    var identificadores = service.getAllIdentificadores();

    return Response.ok(identificadores).build();
  }
}
