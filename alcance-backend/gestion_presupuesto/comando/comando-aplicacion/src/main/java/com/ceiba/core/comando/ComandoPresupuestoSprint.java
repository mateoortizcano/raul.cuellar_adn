package com.ceiba.core.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComandoPresupuestoSprint {
    private Long id;
    private Long idConcepto;
    private Double horasPlaneadas;
    private Double valorPlaneado;
    private Double horasEjecutadas;
    private Double valorEjecutado;
}
