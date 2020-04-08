package com.ceiba.core.manejador.sprint;

import com.ceiba.core.aplicacion.manejador.ManejadorComando;
import com.ceiba.core.comando.ComandoSprint;
import com.ceiba.core.fabrica.FabricaSprint;
import com.ceiba.core.modelo.Sprint;
import com.ceiba.core.servicio.sprint.ServicioActualizarSprint;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarSprint implements ManejadorComando<ComandoSprint> {

	private final FabricaSprint fabricaSprint;
	private final ServicioActualizarSprint servicioActualizarSprint;

	public ManejadorActualizarSprint(FabricaSprint fabricaSprint, ServicioActualizarSprint servicioActualizarSprint) {
		this.fabricaSprint = fabricaSprint;
		this.servicioActualizarSprint = servicioActualizarSprint;
	}

	public void ejecutar(ComandoSprint comandoSprint) {
		Sprint sprint = this.fabricaSprint.crear(comandoSprint);
		this.servicioActualizarSprint.ejecutar(sprint);
	}
}
