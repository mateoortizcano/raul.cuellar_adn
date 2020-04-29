package com.ceiba.core.modelo.presupuesto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoPresupuesto {
    private Long id;
    private Double valor;
    private Double reservaEstabilizacion;
    private String observaciones;
    private Long idProyecto;
}
