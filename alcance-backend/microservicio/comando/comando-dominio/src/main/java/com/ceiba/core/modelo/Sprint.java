package com.ceiba.core.modelo;

import java.time.LocalDateTime;

import static com.ceiba.core.dominio.ValidadorArgumento.validarObligatorio;

public class Sprint {

    private static final String MSG_FECHA_INICIAL_OBLIGATORIO = "Proporcione una fecha de inicio de sprint";
    private static final String MSG_FECHA_FINAL_OBLIGATORIO = "Proporcione una fecha de finalización de sprint";

    private Long id;
    private String nombre;
    private LocalDateTime fechaInicial;
    private LocalDateTime fechaFinal;
    private Integer diasHabiles;
    private Integer numeroPersonas;
    private Integer idProyecto;

    public Sprint(Long id, String nombre, LocalDateTime fechaInicial, LocalDateTime fechaFinal, Integer diasHabiles, Integer numeroPersonas, Integer idProyecto) {

        validarObligatorio(fechaInicial, MSG_FECHA_INICIAL_OBLIGATORIO);
        validarObligatorio(fechaFinal, MSG_FECHA_FINAL_OBLIGATORIO);

        this.id = id;
        this.nombre = nombre;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.diasHabiles = diasHabiles;
        this.numeroPersonas = numeroPersonas;
        this.idProyecto = idProyecto;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDateTime getFechaInicial() {
        return fechaInicial;
    }

    public LocalDateTime getFechaFinal() {
        return fechaFinal;
    }

    public Integer getDiasHabiles() {
        return diasHabiles;
    }

    public Integer getNumeroPersonas() {
        return numeroPersonas;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }
}
