package com.ceiba.core.testdatabuilder;

import com.ceiba.core.comando.ComandoPresupuesto;

import java.util.UUID;

public class ComandoPresupuestoTestDataBuilder {

    private Long id;
    private Double valor;
    private Double reserva_estabilizacion;
    private String observaciones;

    public ComandoPresupuestoTestDataBuilder() {
        this.valor = 258478952.0;
        this.reserva_estabilizacion = 25847895.0;
        this. observaciones = UUID.randomUUID().toString();
    }

    public ComandoPresupuestoTestDataBuilder(Double valor, Double reserva_estabilizacion, String observaciones) {
        this.valor = valor;
        this.reserva_estabilizacion = reserva_estabilizacion;
        this.observaciones = observaciones;
    }

    public ComandoPresupuestoTestDataBuilder(Double valor, Double reserva_estabilizacion) {
        this.valor = valor;
        this.reserva_estabilizacion = reserva_estabilizacion;
        this.observaciones = null;
    }

    public ComandoPresupuesto build() {
    	return new ComandoPresupuesto(id, valor, reserva_estabilizacion, observaciones);
    }
}
