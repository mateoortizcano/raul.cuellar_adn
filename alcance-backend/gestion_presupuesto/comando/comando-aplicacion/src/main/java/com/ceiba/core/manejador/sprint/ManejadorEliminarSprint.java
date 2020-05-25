package com.ceiba.core.manejador.sprint;

import com.ceiba.core.aplicacion.manejador.ManejadorComando;
import com.ceiba.core.repositorio.RepositorioPresupuestoSprint;
import com.ceiba.core.repositorio.RepositorioSprint;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ManejadorEliminarSprint implements ManejadorComando<Long> {

	private final RepositorioSprint repositorioSprint;
	private final RepositorioPresupuestoSprint repositorioPresupuestoSprint;

	public ManejadorEliminarSprint(RepositorioSprint repositorioSprint, RepositorioPresupuestoSprint repositorioPresupuestoSprint) {
		this.repositorioSprint = repositorioSprint;
		this.repositorioPresupuestoSprint = repositorioPresupuestoSprint;
	}

	public void ejecutar(Long idSprint) {
		this.repositorioPresupuestoSprint.eliminar(idSprint, new ArrayList<>());
		this.repositorioSprint.eliminar(idSprint);
	}
}
