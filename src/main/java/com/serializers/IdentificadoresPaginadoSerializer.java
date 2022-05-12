package com.serializers;

import java.util.List;

import com.models.Identificador;
import com.parameters.PaginacaoParameter;

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
public class IdentificadoresPaginadoSerializer {
  private List<Identificador> identificadores;

  private PaginacaoParameter paginacao;
}
