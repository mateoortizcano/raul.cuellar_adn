package com.ceiba.core.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoSprint {
    private Long id;
    private String nombre;
    private LocalDateTime fechaInicial;
    private LocalDateTime fechaFinal;
    private Integer diasHabiles;
    private Integer numeroPersonas;
    private Long idProyecto;
}
