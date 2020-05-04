package com.ceiba.core.servicio.testdatabuilder;

import com.ceiba.core.modelo.Sprint;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SprintTestDataBuilder {

    private Long id;
    private String nombre;
    private LocalDateTime fechaInicial;
    private LocalDateTime fechaFinal;
    private Integer numeroPersonas;
    private Long idProyecto;

    public SprintTestDataBuilder(Long id, String nombre, LocalDateTime fechaInicial, LocalDateTime fechaFinal, Integer numeroPersonas, Long idProyecto) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.numeroPersonas = numeroPersonas;
        this.idProyecto = idProyecto;
    }

    public Sprint build() {
    	return new Sprint(id,nombre, fechaInicial, fechaFinal, numeroPersonas,idProyecto, new ArrayList<>());
    }
}
