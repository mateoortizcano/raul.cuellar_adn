package com.ceiba.core.modelo.proyecto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoProyecto {
    private Long id;
    private String nombre;
    private String cliente;
}
