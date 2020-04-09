package com.ceiba.core.manejador.presupuesto;

import com.ceiba.core.aplicacion.manejador.ManejadorComando;
import com.ceiba.core.repositorio.RepositorioPresupuesto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarPresupuesto implements ManejadorComando<Long> {

	private final RepositorioPresupuesto repositorioPresupuesto;

	public ManejadorEliminarPresupuesto(RepositorioPresupuesto repositorioPresupuesto) {
		this.repositorioPresupuesto = repositorioPresupuesto;
	}

	public void ejecutar(Long idPresupuesto) {
		this.repositorioPresupuesto.eliminar(idPresupuesto);

	}
}
