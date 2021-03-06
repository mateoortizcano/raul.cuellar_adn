package com.ceiba.core.testdatabuilder;

import com.ceiba.core.comando.ComandoPresupuesto;

public class ComandoPresupuestoTestDataBuilder {

    private Long id;
    private Double valor;
    private Double reservaEstabilizacion;
    private String observaciones;
    private Long idProyecto;

    public ComandoPresupuestoTestDataBuilder(Double valor, Double reservaEstabilizacion, String observaciones) {
        this.valor = valor;
        this.reservaEstabilizacion = reservaEstabilizacion;
        this.observaciones = observaciones;
        this.idProyecto = 1L;
    }

    public ComandoPresupuestoTestDataBuilder(Double valor, Double reservaEstabilizacion) {
        this.valor = valor;
        this.reservaEstabilizacion = reservaEstabilizacion;
        this.observaciones = null;
        this.idProyecto = 1L;
    }

    public ComandoPresupuesto build() {
    	return new ComandoPresupuesto(id, valor, reservaEstabilizacion, observaciones, idProyecto);
    }
}
