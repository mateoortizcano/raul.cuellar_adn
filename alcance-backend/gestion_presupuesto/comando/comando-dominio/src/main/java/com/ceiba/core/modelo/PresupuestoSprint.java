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

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdSprint(Long idSprint) {
        this.idSprint = idSprint;
    }

    public void setIdConcepto(Long idConcepto) {
        this.idConcepto = idConcepto;
    }

    public void setHorasPlaneadas(Double horasPlaneadas) {
        this.horasPlaneadas = horasPlaneadas;
    }

    public void setHorasEjecutadas(Double horasEjecutadas) {
        this.horasEjecutadas = horasEjecutadas;
    }

    public void setValorPlaneado(Double valorPlaneado) {
        this.valorPlaneado = valorPlaneado;
    }

    public void setValorEjecutado(Double valorEjecutado) {
        this.valorEjecutado = valorEjecutado;
    }
}
