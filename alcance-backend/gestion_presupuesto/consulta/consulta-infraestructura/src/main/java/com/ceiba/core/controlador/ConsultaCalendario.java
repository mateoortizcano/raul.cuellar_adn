package com.ceiba.core.controlador;


import java.time.LocalDateTime;

public class ConsultaCalendario {
    private LocalDateTime fechaInicial;
    private LocalDateTime fechaFinal;

    public ConsultaCalendario(LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
    }

    public ConsultaCalendario() {
    }

    public LocalDateTime getFechaInicial() {
        return fechaInicial;
    }

    public LocalDateTime getFechaFinal() {
        return fechaFinal;
    }
}
