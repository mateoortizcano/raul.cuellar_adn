package com.ceiba.core.manejador.sprint;

import com.ceiba.core.aplicacion.manejador.ManejadorComando;
import com.ceiba.core.repositorio.RepositorioPresupuesto;
import com.ceiba.core.repositorio.RepositorioSprint;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarSprint implements ManejadorComando<Long> {

	private final RepositorioSprint repositorioSprint;

	public ManejadorEliminarSprint(RepositorioSprint repositorioSprint) {
		this.repositorioSprint = repositorioSprint;
	}

	public void ejecutar(Long idSprint) {
		this.repositorioSprint.eliminar(idSprint);

	}
}
