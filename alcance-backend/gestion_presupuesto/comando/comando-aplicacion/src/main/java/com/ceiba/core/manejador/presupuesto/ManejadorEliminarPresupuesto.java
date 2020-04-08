package com.ceiba.core.manejador.presupuesto;

import com.ceiba.core.aplicacion.manejador.ManejadorComando;
import com.ceiba.core.servicio.presupuesto.ServicioEliminarPresupuesto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarPresupuesto implements ManejadorComando<Long> {

	private final ServicioEliminarPresupuesto servicioEliminarPresupuesto;

	public ManejadorEliminarPresupuesto(ServicioEliminarPresupuesto servicioEliminarPresupuesto) {
		this.servicioEliminarPresupuesto = servicioEliminarPresupuesto;
	}

	public void ejecutar(Long idUsuario) {
		this.servicioEliminarPresupuesto.ejecutar(idUsuario);

	}
}
