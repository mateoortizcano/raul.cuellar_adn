package com.ceiba.core.manejador.sprint;

import com.ceiba.core.aplicacion.manejador.ManejadorComando;
import com.ceiba.core.comando.ComandoPresupuestoSprint;
import com.ceiba.core.comando.ComandoSprint;
import com.ceiba.core.fabrica.FabricaPresupuestoSprint;
import com.ceiba.core.fabrica.FabricaSprint;
import com.ceiba.core.modelo.PresupuestoSprint;
import com.ceiba.core.modelo.Sprint;
import com.ceiba.core.repositorio.RepositorioPresupuestoSprint;
import com.ceiba.core.servicio.sprint.ServicioActualizarSprint;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManejadorActualizarSprint implements ManejadorComando<ComandoSprint> {

	private final FabricaSprint fabricaSprint;
	private final ServicioActualizarSprint servicioActualizarSprint;
	private final FabricaPresupuestoSprint fabricaPresupuestoSprint;
	private final RepositorioPresupuestoSprint repositorioPresupuestoSprint;

	public ManejadorActualizarSprint(FabricaSprint fabricaSprint,
									 ServicioActualizarSprint servicioActualizarSprint,
									 FabricaPresupuestoSprint fabricaPresupuestoSprint,
									 RepositorioPresupuestoSprint repositorioPresupuestoSprint) {
		this.fabricaSprint = fabricaSprint;
		this.servicioActualizarSprint = servicioActualizarSprint;
		this.fabricaPresupuestoSprint = fabricaPresupuestoSprint;
		this.repositorioPresupuestoSprint = repositorioPresupuestoSprint;
	}

	public void ejecutar(ComandoSprint comandoSprint) {
		Sprint sprint = this.fabricaSprint.crear(comandoSprint);

		List<Long> idsPermanecer = new ArrayList<>();
		List<PresupuestoSprint> presupuestoSprintsCrear = new ArrayList<>();
		List<PresupuestoSprint> presupuestoSprintsActualizar = new ArrayList<>();

		for (ComandoPresupuestoSprint comandoPresupuestoSprint : comandoSprint.getPresupuestoSprint()){
			PresupuestoSprint presupuestoSprint = this.fabricaPresupuestoSprint.crear(sprint.getId(), comandoPresupuestoSprint);
			if(comandoPresupuestoSprint.getId() > 0){
				presupuestoSprintsActualizar.add(presupuestoSprint);
				idsPermanecer.add(comandoPresupuestoSprint.getId());
			}else{
				presupuestoSprintsCrear.add(presupuestoSprint);
			}
		}
		this.repositorioPresupuestoSprint.eliminar(comandoSprint.getId(), idsPermanecer);
		for (PresupuestoSprint presupuestoSprint : presupuestoSprintsCrear){
			this.repositorioPresupuestoSprint.crear(presupuestoSprint);
		}
		for (PresupuestoSprint presupuestoSprint : presupuestoSprintsActualizar){
			this.repositorioPresupuestoSprint.actualizar(presupuestoSprint);
		}
		this.servicioActualizarSprint.ejecutar(sprint);
	}
}
