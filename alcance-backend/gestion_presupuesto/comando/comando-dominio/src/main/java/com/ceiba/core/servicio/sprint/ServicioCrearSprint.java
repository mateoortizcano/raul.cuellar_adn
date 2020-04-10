package com.ceiba.core.servicio.sprint;

import com.ceiba.core.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.core.modelo.Sprint;
import com.ceiba.core.repositorio.RepositorioSprint;

public class ServicioCrearSprint {

	private static final String EL_NOMBRE_SPRINT_YA_EXISTE = "Ya existe un sprint con ese nombre";
	private static final String EL_PERIODO_SPRINT_YA_EXISTE = "Ya existe un sprint para el periodo descrito";

	private final RepositorioSprint repositorioSprint;

	public ServicioCrearSprint(RepositorioSprint repositorioSprint) {
		this.repositorioSprint = repositorioSprint;
	}

	public Long ejecutar(Sprint sprint) {
		validarNombreExistente(sprint);
		validarPeriodoExistente(sprint);
		return this.repositorioSprint.crear(sprint);
	}

	private void validarNombreExistente(Sprint sprint) {
		boolean existe = this.repositorioSprint.existeNombre(sprint.getNombre());
		if(existe) {
			throw new ExcepcionDuplicidad(EL_NOMBRE_SPRINT_YA_EXISTE);
		}
	}

	private void validarPeriodoExistente(Sprint sprint) {
		boolean existe = this.repositorioSprint.existePeriodo(
				sprint.getFechaInicial(),
				sprint.getFechaFinal());
		if(existe) {
			throw new ExcepcionDuplicidad(EL_PERIODO_SPRINT_YA_EXISTE);
		}
	}
}
