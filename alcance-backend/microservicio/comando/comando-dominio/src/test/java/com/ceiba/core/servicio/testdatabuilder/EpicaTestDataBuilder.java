package com.ceiba.core.servicio.testdatabuilder;

import com.ceiba.core.modelo.Epica;

public class EpicaTestDataBuilder {

    private Long id;
    private String titulo;
    private Integer estimacionComercial;

    public EpicaTestDataBuilder(String titulo, Integer estimacionComercial) {
        this.titulo = titulo;
        this.estimacionComercial = estimacionComercial;
    }

    public Epica build() {
    	return new Epica(Integer.toUnsignedLong(0), titulo, estimacionComercial);
    }
}
