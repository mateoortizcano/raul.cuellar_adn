package com.ceiba.core.modelo;

import static com.ceiba.core.dominio.ValidadorArgumento.validarPositivo;

public class Presupuesto {
    private static final String MSG_VALOR_POSITIVO_MAYOR_0 = "Proporcione un valor para el presupuesto";
    private static final String MSG_RESERVA_POSITIVO_MAYOR_0 = "Proporcione un valor para la reserva de estabilización";

    private Long id;
    private Double valor;
    private Double reservaEstabilizacion;
    private String observaciones;
    private Integer idProyecto;

    public Presupuesto(Long id, Double valor, Double reservaEstabilizacion, String observaciones, Integer idProyecto) {

        validarPositivo(valor, MSG_VALOR_POSITIVO_MAYOR_0);
        validarPositivo(reservaEstabilizacion, MSG_RESERVA_POSITIVO_MAYOR_0);

        this.id = id;
        this.valor = valor;
        this.reservaEstabilizacion = reservaEstabilizacion;
        this.observaciones = observaciones;
        this.idProyecto = idProyecto;
    }

    public Long getId() {
        return id;
    }

    public Double getValor() {
        return valor;
    }

    public Double getReservaEstabilizacion() {
        return reservaEstabilizacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }
}
