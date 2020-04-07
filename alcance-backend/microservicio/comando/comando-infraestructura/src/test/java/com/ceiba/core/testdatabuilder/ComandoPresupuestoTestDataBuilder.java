package com.ceiba.core.testdatabuilder;

import com.ceiba.core.comando.ComandoPresupuesto;

import java.util.UUID;

public class ComandoPresupuestoTestDataBuilder {

    private Long id;
    private Double valor;
    private Double reservaEstabilizacion;
    private String observaciones;

    public ComandoPresupuestoTestDataBuilder() {
        this.valor = 258478952.0;
        this.reservaEstabilizacion = 25847895.0;
        this. observaciones = UUID.randomUUID().toString();
    }

    public ComandoPresupuestoTestDataBuilder(Double valor, Double reservaEstabilizacion, String observaciones) {
        this.valor = valor;
        this.reservaEstabilizacion = reservaEstabilizacion;
        this.observaciones = observaciones;
    }

    public ComandoPresupuestoTestDataBuilder(Double valor, Double reservaEstabilizacion) {
        this.valor = valor;
        this.reservaEstabilizacion = reservaEstabilizacion;
        this.observaciones = null;
    }

    public ComandoPresupuesto build() {
    	return new ComandoPresupuesto(id, valor, reservaEstabilizacion, observaciones);
    }
}
