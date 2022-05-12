package com.parameters;

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
public class PaginacaoParameter {
  private Integer pagina;

  private Integer quantidade;

  private Integer total;

  private Integer proxima;

  private Integer anterior;

  public PaginacaoParameter(Integer pagina, Integer quantidade) {
    this.pagina = pagina;
    this.quantidade = quantidade;
  }

  public PaginacaoParameter(Integer pagina, Integer quantidade, Integer total, Boolean maisRegistros) {
    this.pagina = pagina;
    this.quantidade = quantidade;
    this.total = total;
    this.proxima = !maisRegistros ? null : pagina + 1;
    this.anterior = pagina == 1 ? null : pagina - 1;
  }
}
