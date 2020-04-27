package com.ceiba.core.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoProyectoResumen {
    private Long id;
    private String nombre;
    private String cliente;
    private Double presupuestoGlobal;
    private Double presupuestoConsumido;
}
