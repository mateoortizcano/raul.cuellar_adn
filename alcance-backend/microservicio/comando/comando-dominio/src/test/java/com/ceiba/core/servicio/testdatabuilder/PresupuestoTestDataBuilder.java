package com.ceiba.core.servicio.testdatabuilder;

import com.ceiba.core.modelo.Presupuesto;

public class PresupuestoTestDataBuilder {

    private Double valor;
    private Double reservaEstabilizacion;
    private String observaciones;

    public PresupuestoTestDataBuilder(Double valor, Double reservaEstabilizacion, String observaciones) {
        this.valor = valor;
        this.reservaEstabilizacion = reservaEstabilizacion;
        this.observaciones = observaciones;
    }

    public Presupuesto build() {
    	return new Presupuesto(Integer.toUnsignedLong(0), valor, reservaEstabilizacion, observaciones);
    }
}
