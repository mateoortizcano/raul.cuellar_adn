package com.ceiba.core.testdatabuilder;

import com.ceiba.core.comando.epica.ComandoEpica;
import com.ceiba.core.comando.usuario.ComandoUsuario;

import java.util.UUID;

public class ComandoEpicaTestDataBuilder {

	private Long id;
    private String titulo;
    private Integer estimacion_comercial;

    public ComandoEpicaTestDataBuilder() {
		titulo = UUID.randomUUID().toString();
		estimacion_comercial = 999999;
	}

    public ComandoEpica build() {
    	return new ComandoEpica(id, titulo, estimacion_comercial);
    }
}
