package com.ceiba.core.modelo;

import static com.ceiba.core.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.core.dominio.ValidadorArgumento.validarPositivo;

public class Presupuesto {
    private static final String MSG_VALOR_POSITIVO_MAYOR_0 = "Proporcione un valor válido para el presupuesto";
    private static final String MSG_RESERVA_POSITIVO_MAYOR_0 = "Proporcione un valor válido para la reserva de estabilización";
    private static final String MSG_IDPROYECTO_OBLIGATORIO = "Indique el proyecto al que pertenece el presupuesto";
    private static final String MSG_VALOR_OBLIGATORIO = "Proporcione un valor para el presupuesto";
    private static final String MSG_RESERVA_OBLIGATORIO = "Proporcione un valor para la reserva de estabilización";

    private Long id;
    private Double valor;
    private Double reservaEstabilizacion;
    private String observaciones;
    private Integer idProyecto;

    public Presupuesto(Long id, Double valor, Double reservaEstabilizacion, String observaciones, Integer idProyecto) {

        validarObligatorio(valor, MSG_VALOR_OBLIGATORIO);
        validarPositivo(valor, MSG_VALOR_POSITIVO_MAYOR_0);
        validarObligatorio(reservaEstabilizacion, MSG_RESERVA_OBLIGATORIO);
        validarPositivo(reservaEstabilizacion, MSG_RESERVA_POSITIVO_MAYOR_0);
        validarObligatorio(idProyecto, MSG_IDPROYECTO_OBLIGATORIO);

        this.id = id;
        this.valor = valor;
        this.reservaEstabilizacion = reservaEstabilizacion;
        this.observaciones = observaciones;
        this.idProyecto = idProyecto;
    }

    public Long getId() {
        return id;
    }
}
