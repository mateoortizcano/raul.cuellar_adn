package com.ceiba.core.fabrica;

import com.ceiba.core.comando.ComandoSprint;
import com.ceiba.core.modelo.PresupuestoSprint;
import com.ceiba.core.modelo.Sprint;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FabricaSprint {
	
	public Sprint crear(ComandoSprint comandoSprint) {
		List<PresupuestoSprint> presupuestoSprintList = new ArrayList<>();
		for(Long concepto: comandoSprint.getConceptos()){
			presupuestoSprintList.add(new PresupuestoSprint(
					0L,
					comandoSprint.getId(),
					concepto,
					0.0,
					0.0,
					0.0,
					0.0
			));
		}
	    return new Sprint(
	    	comandoSprint.getId(),
	        comandoSprint.getNombre(),
			comandoSprint.getFechaInicial(),
			comandoSprint.getFechaFinal(),
			comandoSprint.getNumeroPersonas(),
			comandoSprint.getIdProyecto(),
			presupuestoSprintList
	    );
	}

}
