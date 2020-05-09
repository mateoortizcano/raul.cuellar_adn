package com.ceiba.core.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComandoConcepto {
    private Long id;
    private Double horasSugeridas;
    private Double valorSugerido;
}
