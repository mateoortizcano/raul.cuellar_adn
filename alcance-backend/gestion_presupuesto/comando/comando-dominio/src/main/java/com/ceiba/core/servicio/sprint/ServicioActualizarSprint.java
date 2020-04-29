package com.ceiba.core.servicio.sprint;

import com.ceiba.core.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.core.modelo.Sprint;
import com.ceiba.core.repositorio.RepositorioSprint;

public class ServicioActualizarSprint {

    private static final String EL_NOMBRE_SPRINT_YA_EXISTE = "Ya existe un sprint con ese nombre";
    private static final String EL_PERIODO_SPRINT_YA_EXISTE = "Ya existe un sprint para el periodo descrito";
    private final RepositorioSprint repositorioSprint;

    public ServicioActualizarSprint(RepositorioSprint repositorioSprint) {
        this.repositorioSprint= repositorioSprint;
    }

    public void ejecutar(Sprint sprint) {
        validarNombreExistente(sprint);
        validarPeriodoExistente(sprint);
        this.repositorioSprint.actualizar(sprint);
    }

    private void validarNombreExistente(Sprint sprint) {
        boolean existe = this.repositorioSprint.existeNombreExcluyendoId(
                sprint.getId(),
                sprint.getNombre(),
                sprint.getIdProyecto());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_NOMBRE_SPRINT_YA_EXISTE);
        }
    }
    private void validarPeriodoExistente(Sprint sprint) {
        boolean existe = this.repositorioSprint.existePeriodoExcluyendoId(
                sprint.getId(),
                sprint.getFechaInicial(),
                sprint.getFechaFinal(),
                sprint.getIdProyecto());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_PERIODO_SPRINT_YA_EXISTE);
        }
    }
}
