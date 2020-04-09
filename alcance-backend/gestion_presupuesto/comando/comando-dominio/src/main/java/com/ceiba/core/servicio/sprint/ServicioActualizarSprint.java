package com.ceiba.core.servicio.sprint;

import com.ceiba.core.modelo.Sprint;
import com.ceiba.core.repositorio.RepositorioSprint;

public class ServicioActualizarSprint {

	private final RepositorioSprint repositorioSprint;

    public ServicioActualizarSprint(RepositorioSprint repositorioSprint) {
        this.repositorioSprint= repositorioSprint;
    }

    public void ejecutar(Sprint sprint) {
        this.repositorioSprint.actualizar(sprint);
    }
}
