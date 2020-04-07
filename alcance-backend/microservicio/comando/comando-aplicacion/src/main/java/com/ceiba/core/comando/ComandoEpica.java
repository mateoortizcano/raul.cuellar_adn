package com.ceiba.core.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoEpica {
    private Long id;
    private String titulo;
    private Integer estimacion_comercial;
}
