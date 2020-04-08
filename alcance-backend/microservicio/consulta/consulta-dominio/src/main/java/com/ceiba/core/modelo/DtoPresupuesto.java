package com.ceiba.core.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoPresupuesto {
    private Long id;
    private Double valor;
    private Double reservaEstabilizacion;
    private String observaciones;
    private Integer id_proyecto;
}
