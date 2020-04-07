package com.ceiba.core.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPresupuesto {
    private Long id;
    private Double valor;
    private Double reservaEstabilizacion;
    private String observaciones;
}
