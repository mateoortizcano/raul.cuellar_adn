package com.ceiba.core.modelo.epica;

import static com.ceiba.core.dominio.ValidadorArgumento.validarObligatorio;

public class Epica {
    private static final String MSG_TITULO_OBLIGATORIO = "La épica debe tener un título";
    private static final String MSG_ESTIMACION_COMERCIAL_OBLIGATORIA = "La épica debe tener una estimación comercial";
    private Long id;
    private String titulo;
    private Integer estimacion_comercial;

    public Epica(Long id, String titulo, Integer estimacion_comercial) {

        validarObligatorio(titulo, MSG_TITULO_OBLIGATORIO);
        validarObligatorio(estimacion_comercial, MSG_ESTIMACION_COMERCIAL_OBLIGATORIA);
        
        this.id = id;
        this.titulo = titulo;
        this.estimacion_comercial = estimacion_comercial;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getEstimacion_comercial() {
        return estimacion_comercial;
    }
}
