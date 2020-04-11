package com.ceiba.core.testdatabuilder;

import com.ceiba.core.comando.ComandoSprint;

import java.time.LocalDateTime;

public class ComandoSprintTestDataBuilder {

    private Long id;
    private String nombre;
    private LocalDateTime fechaInicial;
    private LocalDateTime fechaFinal;
    private Integer numeroPersonas;
    private Long idProyecto;

    public ComandoSprintTestDataBuilder(Long id, String nombre, LocalDateTime fechaInicial, LocalDateTime fechaFinal, Integer numeroPersonas) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.numeroPersonas = numeroPersonas;
        this.idProyecto = 1L;
    }

    public ComandoSprint build() {
    	return new ComandoSprint(id, nombre, fechaInicial, fechaFinal, numeroPersonas, idProyecto);
    }
}
