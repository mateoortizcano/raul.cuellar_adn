package com.ceiba.core.servicio.testdatabuilder;

import com.ceiba.core.modelo.Presupuesto;

public class PresupuestoTestDataBuilder {

    private Double valor;
    private Double reservaEstabilizacion;
    private String observaciones;
    private Long idProyecto;

    public PresupuestoTestDataBuilder(Double valor, Double reservaEstabilizacion, String observaciones, Long idProyecto) {
        this.valor = valor;
        this.reservaEstabilizacion = reservaEstabilizacion;
        this.observaciones = observaciones;
        this.idProyecto = idProyecto;
    }

    public Presupuesto build() {
    	return new Presupuesto(1L, valor, reservaEstabilizacion, observaciones, idProyecto);
    }
}
