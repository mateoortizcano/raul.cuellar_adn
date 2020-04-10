package com.ceiba.core.manejador.sprint;

import com.ceiba.core.aplicacion.ComandoRespuesta;
import com.ceiba.core.aplicacion.manejador.ManejadorComandoRespuesta;
import com.ceiba.core.comando.ComandoSprint;
import com.ceiba.core.fabrica.FabricaSprint;
import com.ceiba.core.modelo.Sprint;
import com.ceiba.core.servicio.sprint.ServicioCrearSprint;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearSprint implements ManejadorComandoRespuesta<ComandoSprint, ComandoRespuesta<Long>> {

	private final FabricaSprint fabricaSprint;
	private final ServicioCrearSprint servicioCrearSprint;

	public ManejadorCrearSprint(FabricaSprint fabricaSprint, ServicioCrearSprint servicioCrearSprint) {
		this.fabricaSprint = fabricaSprint;
		this.servicioCrearSprint = servicioCrearSprint;
	}

	public ComandoRespuesta<Long> ejecutar(ComandoSprint comandoSprint) {
		Sprint sprint = this.fabricaSprint.crear(comandoSprint);
		return new ComandoRespuesta<>(this.servicioCrearSprint.ejecutar(sprint));
	}
}
