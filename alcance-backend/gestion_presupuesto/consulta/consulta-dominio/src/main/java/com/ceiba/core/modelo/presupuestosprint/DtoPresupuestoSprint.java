package com.ceiba.core.modelo.presupuestosprint;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoPresupuestoSprint {
    private Long id;
    private Long idSprint;
    private Long idConcepto;
    private String nombreConcepto;
    private Double tarifaConcepto;
    private Boolean tiempoCompletoConcepto;
    private Double horasPlaneadas;
    private Double horasEjecutadas;
    private Double valorPlaneado;
    private Double valorEjecutado;
}
