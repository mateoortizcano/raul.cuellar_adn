package com.ceiba.core.modelo;

import static com.ceiba.core.dominio.ValidadorArgumento.validarPositivoCero;

public class PresupuestoSprint {
    private static final String MSG_H_PLANEADAS_POSITIVO_MAYOR_0 = "Proporcione un valor válido para las horas planeadas";
    private static final String MSG_H_EJECUTADAS_POSITIVO_MAYOR_0 = "Proporcione un valor válido para las horas ejecutadas";
    private static final String MSG_V_PLANEADO_POSITIVO_MAYOR_0 = "Proporcione un valor válido para el valor planeado";
    private static final String MSG_V_EJECUTADO_POSITIVO_MAYOR_0 = "Proporcione un valor válido para el valor ejecutado";

    private Long id;
    private Long idSprint;
    private Long idConcepto;
    private Double horasPlaneadas;
    private Double horasEjecutadas;
    private Double valorPlaneado;
    private Double valorEjecutado;

    public PresupuestoSprint(Long id, Long idSprint, Long idConcepto, Double horasPlaneadas,
                             Double horasEjecutadas, Double valorPlaneado, Double valorEjecutado) {
        validarPositivoCero(horasPlaneadas, MSG_H_PLANEADAS_POSITIVO_MAYOR_0);
        validarPositivoCero(horasEjecutadas, MSG_H_EJECUTADAS_POSITIVO_MAYOR_0);
        validarPositivoCero(valorPlaneado, MSG_V_PLANEADO_POSITIVO_MAYOR_0);
        validarPositivoCero(valorEjecutado, MSG_V_EJECUTADO_POSITIVO_MAYOR_0);

        this.id = id;
        this.idSprint = idSprint;
        this.idConcepto = idConcepto;
        this.horasPlaneadas = horasPlaneadas;
        this.horasEjecutadas = horasEjecutadas;
        this.valorPlaneado = valorPlaneado;
        this.valorEjecutado = valorEjecutado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdSprint() {
        return idSprint;
    }

    public void setIdSprint(Long idSprint) {
        this.idSprint = idSprint;
    }

    public Long getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(Long idConcepto) {
        this.idConcepto = idConcepto;
    }

    public Double getHorasPlaneadas() {
        return horasPlaneadas;
    }

    public void setHorasPlaneadas(Double horasPlaneadas) {
        this.horasPlaneadas = horasPlaneadas;
    }

    public Double getHorasEjecutadas() {
        return horasEjecutadas;
    }

    public void setHorasEjecutadas(Double horasEjecutadas) {
        this.horasEjecutadas = horasEjecutadas;
    }

    public Double getValorPlaneado() {
        return valorPlaneado;
    }

    public void setValorPlaneado(Double valorPlaneado) {
        this.valorPlaneado = valorPlaneado;
    }

    public Double getValorEjecutado() {
        return valorEjecutado;
    }

    public void setValorEjecutado(Double valorEjecutado) {
        this.valorEjecutado = valorEjecutado;
    }
}
