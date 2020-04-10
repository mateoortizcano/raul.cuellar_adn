package com.ceiba.core.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoPresupuestoGlobal {
    private Double valor;
    private Double reservaEstabilizacion;
    private Long idProyecto;
}
