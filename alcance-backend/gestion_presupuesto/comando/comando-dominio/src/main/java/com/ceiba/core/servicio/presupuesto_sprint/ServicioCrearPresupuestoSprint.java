package com.ceiba.core.servicio.presupuesto_sprint;

import com.ceiba.core.modelo.PresupuestoSprint;
import com.ceiba.core.repositorio.RepositorioPresupuestoSprint;

public class ServicioCrearPresupuestoSprint {

	private final RepositorioPresupuestoSprint repositorioPresupuestoSprint;

	public ServicioCrearPresupuestoSprint(RepositorioPresupuestoSprint repositorioPresupuestoSprint) {
		this.repositorioPresupuestoSprint = repositorioPresupuestoSprint;
	}

	public Long ejecutar(PresupuestoSprint presupuestoSprint) {
		return this.repositorioPresupuestoSprint.crear(presupuestoSprint);
	}
}
