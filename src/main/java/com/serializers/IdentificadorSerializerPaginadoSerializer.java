package com.serializers;

import java.util.List;
import java.util.stream.Collectors;

import com.models.Identificador;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
public class IdentificadorSerializerPaginadoSerializer {
  private List<IdentificadorSerializer> identificadores;

  private PaginacaoSerializer paginacao;

  public IdentificadorSerializerPaginadoSerializer(IdentificadoresPaginadoSerializer model) {
    this.identificadores = model.getIdentificadores().stream().map(Identificador::toSerializer)
        .collect(Collectors.toList());
    this.paginacao = new PaginacaoSerializer(model.getPaginacao().getPagina(),
        model.getPaginacao().getQuantidade(), model.getPaginacao().getTotal(),
        model.getPaginacao().getProxima(), model.getPaginacao().getAnterior());
  }
}
