package com.ceiba.core.modelo;

import static com.ceiba.core.dominio.util.fechas.FechaUtil.diasEntreDosFechasSinContarFestivosNiFinesDeSemana;

import java.time.LocalDateTime;

import static com.ceiba.core.dominio.ValidadorArgumento.validarMenor;
import static com.ceiba.core.dominio.ValidadorArgumento.validarObligatorio;

public class Sprint {

    private static final String MSG_FECHA_INICIAL_OBLIGATORIO = "Proporcione una fecha de inicio de sprint";
    private static final String MSG_FECHA_FINAL_OBLIGATORIO = "Proporcione una fecha de finalización de sprint";
    private static final String MSG_RANGO_FECHAS_NO_VALIDOS = "La fecha final debe ser posterior a la fecha final";
    private static final String MSG_IDPROYECTO_OBLIGATORIO = "Indique el proyecto al que pertenece el sprint";

    private Long id;
    private String nombre;
    private LocalDateTime fechaInicial;
    private LocalDateTime fechaFinal;
    private Integer diasHabiles;
    private Integer numeroPersonas;
    private Long idProyecto;

    public Sprint(Long id, String nombre, LocalDateTime fechaInicial, LocalDateTime fechaFinal, Integer numeroPersonas, Long idProyecto) {

        validarObligatorio(fechaInicial, MSG_FECHA_INICIAL_OBLIGATORIO);
        validarObligatorio(fechaFinal, MSG_FECHA_FINAL_OBLIGATORIO);
        validarObligatorio(idProyecto, MSG_IDPROYECTO_OBLIGATORIO);
        validarMenor(fechaInicial, fechaFinal, MSG_RANGO_FECHAS_NO_VALIDOS);

        this.id = id;
        this.nombre = nombre;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.diasHabiles = diasEntreDosFechasSinContarFestivosNiFinesDeSemana(fechaInicial, fechaFinal);
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

    public Long getIdProyecto() {
        return idProyecto;
    }
}
