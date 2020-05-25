package com.ceiba.core.modelo;

import static com.ceiba.core.dominio.ValidadorArgumento.validarPositivo;

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
        validarPositivo(horasPlaneadas, MSG_H_PLANEADAS_POSITIVO_MAYOR_0);
        validarPositivo(horasEjecutadas, MSG_H_EJECUTADAS_POSITIVO_MAYOR_0);
        validarPositivo(valorPlaneado, MSG_V_PLANEADO_POSITIVO_MAYOR_0);
        validarPositivo(valorEjecutado, MSG_V_EJECUTADO_POSITIVO_MAYOR_0);

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

    public Long getId() {
        return id;
    }

}
