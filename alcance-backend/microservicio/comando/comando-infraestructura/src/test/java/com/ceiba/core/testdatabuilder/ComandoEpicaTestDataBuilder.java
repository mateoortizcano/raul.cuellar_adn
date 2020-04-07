package com.ceiba.core.testdatabuilder;

import com.ceiba.core.comando.ComandoEpica;

import java.util.UUID;

public class ComandoEpicaTestDataBuilder {

	private Long id;
    private String titulo;
    private Integer estimacionComercial;

    public ComandoEpicaTestDataBuilder() {
		titulo = UUID.randomUUID().toString();
        estimacionComercial = 999999;
	}

    public ComandoEpica build() {
    	return new ComandoEpica(id, titulo, estimacionComercial);
    }
}
