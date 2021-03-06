package com.ceiba.core.modelo.sprint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class DtoSprintResumen {
    private Long id;
    private String nombre;
    private LocalDateTime fechaInicial;
    private LocalDateTime fechaFinal;
    private Integer diasHabiles;
    private Integer numeroPersonas;
    private Long idProyecto;
    private Double valorPlaneado;
    private Double valorEjecutado;
    private Double desviacion;
}
