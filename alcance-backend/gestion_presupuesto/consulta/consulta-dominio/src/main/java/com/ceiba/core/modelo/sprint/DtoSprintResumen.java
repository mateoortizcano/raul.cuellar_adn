package com.ceiba.core.modelo.sprint;

import com.ceiba.core.modelo.presupuestosprint.DtoPresupuestoSprint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

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
    private List<DtoPresupuestoSprint> presupuestosSprint;
}
