package com.ceiba.core.servicio.testdatabuilder;

import com.ceiba.core.modelo.Presupuesto;

public class PresupuestoTestDataBuilder {

    private Double valor;
    private Double reserva_estabilizacion;
    private String observaciones;

    public PresupuestoTestDataBuilder(Double valor, Double reserva_estabilizacion, String observaciones) {
        this.valor = valor;
        this.reserva_estabilizacion = reserva_estabilizacion;
        this.observaciones = observaciones;
    }

    public Presupuesto build() {
    	return new Presupuesto(Integer.toUnsignedLong(0), valor, reserva_estabilizacion, observaciones);
    }
}
