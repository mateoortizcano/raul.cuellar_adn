package com.ceiba.core.modelo.concepto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoConcepto {
    private Long id;
    private String nombre;
    private String gerencia;
    private Boolean tiempoCompleto;
    private Double tarifa;
}
