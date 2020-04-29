package com.ceiba.core.modelo.epica;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoEpica {
    private Integer id;
    private String titulo;
    private Integer estimacionComercial;
}
