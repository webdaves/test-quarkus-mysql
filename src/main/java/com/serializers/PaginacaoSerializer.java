package com.serializers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaginacaoSerializer {
  private Integer pagina;
  private Integer quantidade;
  private Integer total;
  private Integer proxima;
  private Integer anterior;
}
