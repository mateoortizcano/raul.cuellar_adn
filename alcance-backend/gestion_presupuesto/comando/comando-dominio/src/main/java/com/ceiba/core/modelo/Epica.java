package com.ceiba.core.modelo;

import static com.ceiba.core.dominio.ValidadorArgumento.*;

public class Epica {
    private static final String MSG_TITULO_OBLIGATORIO = "La épica debe tener un título";
    private static final String MSG_ESTIMACION_COMERCIAL_OBLIGATORIA = "La épica debe tener una estimación comercial";
    private Long id;
    private String titulo;
    private Integer estimacionComercial;

    public Epica(Long id, String titulo, Integer estimacionComercial) {

        validarObligatorio(titulo, MSG_TITULO_OBLIGATORIO);
        validarLongitudMinima(titulo, 1,  MSG_TITULO_OBLIGATORIO);
        validarObligatorio(estimacionComercial, MSG_ESTIMACION_COMERCIAL_OBLIGATORIA);
        validarPositivo(estimacionComercial, MSG_ESTIMACION_COMERCIAL_OBLIGATORIA);

        this.id = id;
        this.titulo = titulo;
        this.estimacionComercial = estimacionComercial;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getEstimacionComercial() {
        return estimacionComercial;
    }
}
