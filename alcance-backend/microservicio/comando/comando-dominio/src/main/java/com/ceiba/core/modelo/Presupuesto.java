package com.ceiba.core.modelo;

import static com.ceiba.core.dominio.ValidadorArgumento.validarPositivo;

public class Presupuesto {
    private static final String MSG_VALOR_POSITIVO_MAYOR_0 = "Proporcione un valor para el presupuesto";
    private static final String MSG_RESERVA_POSITIVO_MAYOR_0 = "Proporcione un valor para la reserva de estabilización";

    private Long id;
    private Double valor;
    private Double reserva_estabilizacion;
    private String observaciones;

    public Presupuesto(Long id, Double valor, Double reserva_estabilizacion, String observaciones) {

        validarPositivo(valor, MSG_VALOR_POSITIVO_MAYOR_0);
        validarPositivo(reserva_estabilizacion, MSG_RESERVA_POSITIVO_MAYOR_0);

        this.id = id;
        this.valor = valor;
        this.reserva_estabilizacion = reserva_estabilizacion;
        this.observaciones = observaciones;
    }

    public Long getId() {
        return id;
    }

    public Double getValor() {
        return valor;
    }

    public Double getReserva_estabilizacion() {
        return reserva_estabilizacion;
    }

    public String getObservaciones() {
        return observaciones;
    }
}
