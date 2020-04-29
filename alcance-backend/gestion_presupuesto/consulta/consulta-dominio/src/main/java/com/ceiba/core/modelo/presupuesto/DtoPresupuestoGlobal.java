package com.ceiba.core.modelo.presupuesto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoPresupuestoGlobal {
    private Double valor;
    private Double reservaEstabilizacion;
    private Long idProyecto;
}
