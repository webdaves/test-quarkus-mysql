package com.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;

import com.parameters.IdentificadorParameter;
import com.parameters.PaginacaoParameter;
import com.repository.IdentificadorRepository;
import com.serializers.IdentificadorSerializer;
import com.serializers.IdentificadorSerializerPaginadoSerializer;
import com.serializers.IdentificadoresPaginadoSerializer;

import org.apache.commons.lang3.math.NumberUtils;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class IdentificadoresService {

  private final IdentificadorRepository identificadoresRepository;

  @Inject
  public IdentificadoresService(IdentificadorRepository identificadoresRepository) {
    this.identificadoresRepository = identificadoresRepository;
  }

  public Multi<IdentificadorSerializer> getIdentificadores(Integer idConta) {
    var result = identificadoresRepository.listByIdConta(idConta);

    var serializad = result.map(identificador -> identificador.toSerializer());

    return serializad;
  }

  public Uni<IdentificadorSerializerPaginadoSerializer> getIdentificadoresPaginado(Integer idConta,
      MultivaluedMap<String, String> queryParams) {
    int pagina = NumberUtils.toInt(queryParams.getFirst("pagina"), 1);
    int quantidade = NumberUtils.toInt(queryParams.getFirst("quantidade"), 20);
    var parameters = new IdentificadorParameter(idConta, queryParams);

    var result = identificadoresRepository.listPaginadoByIdConta(idConta, parameters).collect().asList();
    var qtd = identificadoresRepository.contarIdentificadores(idConta, parameters);

    var identificadoresPaginado = Uni.combine().all().unis(result, qtd).asTuple().map(tuple -> {
      var paginado = new IdentificadoresPaginadoSerializer();
      paginado.setIdentificadores(tuple.getItem1());
      paginado.setPaginacao(new PaginacaoParameter(
          pagina,
          quantidade,
          tuple.getItem2(),
          existeProximaPagina(parameters.getPaginacao(), tuple.getItem2())));

      return new IdentificadorSerializerPaginadoSerializer(paginado);
    });

    return identificadoresPaginado;
  }

  private Boolean existeProximaPagina(PaginacaoParameter paginacao, Integer qtdIdentificadores) {

    int quantidadeUltimaPagina = qtdIdentificadores % paginacao.getQuantidade();
    int quantidadeDePaginas = qtdIdentificadores / paginacao.getQuantidade();
    if (quantidadeUltimaPagina > 0)
      quantidadeDePaginas++;
    if (quantidadeDePaginas == paginacao.getPagina())
      return Boolean.FALSE;

    return Boolean.TRUE;
  }
}
