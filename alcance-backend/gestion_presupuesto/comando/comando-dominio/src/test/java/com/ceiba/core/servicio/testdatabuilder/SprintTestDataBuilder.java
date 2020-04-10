package com.ceiba.core.servicio.testdatabuilder;

import com.ceiba.core.modelo.Sprint;

import java.time.LocalDateTime;

public class SprintTestDataBuilder {

    private Long id;
    private String nombre;
    private LocalDateTime fechaInicial;
    private LocalDateTime fechaFinal;
    private Integer diasHabiles;
    private Integer numeroPersonas;
    private Long idProyecto;

    public SprintTestDataBuilder(Long id, String nombre, LocalDateTime fechaInicial, LocalDateTime fechaFinal, Integer diasHabiles, Integer numeroPersonas, Long idProyecto) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.diasHabiles = diasHabiles;
        this.numeroPersonas = numeroPersonas;
        this.idProyecto = idProyecto;
    }

    public Sprint build() {
    	return new Sprint(id,nombre, fechaInicial, fechaFinal, diasHabiles, numeroPersonas,idProyecto);
    }
}
