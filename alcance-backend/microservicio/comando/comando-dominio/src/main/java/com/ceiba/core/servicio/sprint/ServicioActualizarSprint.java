package com.ceiba.core.servicio.sprint;

import com.ceiba.core.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.core.modelo.Sprint;
import com.ceiba.core.modelo.Usuario;
import com.ceiba.core.repositorio.RepositorioSprint;

public class ServicioActualizarSprint {

    private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";

	private final RepositorioSprint repositorioSprint;

    public ServicioActualizarSprint(RepositorioSprint repositorioSprint) {
        this.repositorioSprint= repositorioSprint;
    }

    public void ejecutar(Sprint sprint) {
        this.repositorioSprint.actualizar(sprint);
    }
}
