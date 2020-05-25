package com.ceiba.core.manejador.sprint;

import com.ceiba.core.aplicacion.ComandoRespuesta;
import com.ceiba.core.aplicacion.manejador.ManejadorComandoRespuesta;
import com.ceiba.core.comando.ComandoPresupuestoSprint;
import com.ceiba.core.comando.ComandoSprint;
import com.ceiba.core.fabrica.FabricaPresupuestoSprint;
import com.ceiba.core.fabrica.FabricaSprint;
import com.ceiba.core.modelo.PresupuestoSprint;
import com.ceiba.core.modelo.Sprint;
import com.ceiba.core.repositorio.RepositorioPresupuestoSprint;
import com.ceiba.core.servicio.sprint.ServicioCrearSprint;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearSprint implements ManejadorComandoRespuesta<ComandoSprint, ComandoRespuesta<Long>> {

	private final FabricaSprint fabricaSprint;
	private final FabricaPresupuestoSprint fabricaPresupuestoSprint;
	private final ServicioCrearSprint servicioCrearSprint;
	private final RepositorioPresupuestoSprint repositorioPresupuestoSprint;

	public ManejadorCrearSprint(FabricaSprint fabricaSprint,
								FabricaPresupuestoSprint fabricaPresupuestoSprint,
								ServicioCrearSprint servicioCrearSprint,
								RepositorioPresupuestoSprint repositorioPresupuestoSprint) {
		this.fabricaSprint = fabricaSprint;
		this.fabricaPresupuestoSprint = fabricaPresupuestoSprint;
		this.servicioCrearSprint = servicioCrearSprint;
		this.repositorioPresupuestoSprint = repositorioPresupuestoSprint;
	}

	public ComandoRespuesta<Long> ejecutar(ComandoSprint comandoSprint) {
		Sprint sprint = this.fabricaSprint.crear(comandoSprint);
		Long idSprint = this.servicioCrearSprint.ejecutar(sprint);
		for(ComandoPresupuestoSprint comandoPresupuestoSprint: comandoSprint.getPresupuestoSprint()){
			PresupuestoSprint presupuestoSprint = this.fabricaPresupuestoSprint.crear(idSprint, comandoPresupuestoSprint);
			this.repositorioPresupuestoSprint.crear(presupuestoSprint);
		}
		return new ComandoRespuesta<>(idSprint);
	}
}
