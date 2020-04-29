package com.ceiba.core.modelo.proyecto;

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
