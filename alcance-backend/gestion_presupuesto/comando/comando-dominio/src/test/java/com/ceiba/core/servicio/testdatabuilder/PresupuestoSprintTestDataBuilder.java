package com.ceiba.core.servicio.testdatabuilder;

import com.ceiba.core.modelo.Presupuesto;
import com.ceiba.core.modelo.PresupuestoSprint;

public class PresupuestoSprintTestDataBuilder {

    private Long id;
    private Long idSprint;
    private Long idConcepto;
    private Double horasPlaneadas;
    private Double horasEjecutadas;
    private Double valorPlaneado;
    private Double valorEjecutado;

    public PresupuestoSprintTestDataBuilder(Long id, Long idSprint, Long idConcepto, Double horasPlaneadas,
                                            Double horasEjecutadas, Double valorPlaneado, Double valorEjecutado) {
        this.id = id;
        this.idSprint = idSprint;
        this.idConcepto = idConcepto;
        this.horasPlaneadas = horasPlaneadas;
        this.horasEjecutadas = horasEjecutadas;
        this.valorPlaneado = valorPlaneado;
        this.valorEjecutado = valorEjecutado;
    }

    public PresupuestoSprint build() {
    	return new PresupuestoSprint(
    	        this.id,
                this.idSprint,
                this.idConcepto,
                this.horasPlaneadas,
                this.horasEjecutadas,
                this.valorPlaneado,
                this.valorEjecutado
        );
    }
}
