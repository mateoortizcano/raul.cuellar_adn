package com.ceiba.core.modelo;

public class PresupuestoSprint {
    private Long id;
    private Long idSprint;
    private Long idConcepto;
    private Double horasPlaneadas;
    private Double horasEjecutadas;
    private Double valorPlaneado;
    private Double valorEjecutado;

    public PresupuestoSprint(Long id, Long idSprint, Long idConcepto, Double horasPlaneadas,
                             Double horasEjecutadas, Double valorPlaneado, Double valorEjecutado) {
        this.id = id;
        this.idSprint = idSprint;
        this.idConcepto = idConcepto;
        this.horasPlaneadas = horasPlaneadas;
        this.horasEjecutadas = horasEjecutadas;
        this.valorPlaneado = valorPlaneado;
        this.valorEjecutado = valorEjecutado;
    }

    public void setIdSprint(Long idSprint) {
        this.idSprint = idSprint;
    }
}
