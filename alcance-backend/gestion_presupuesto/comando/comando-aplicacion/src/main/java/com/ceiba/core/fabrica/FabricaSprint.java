package com.ceiba.core.fabrica;

import com.ceiba.core.comando.ComandoSprint;
import com.ceiba.core.modelo.Sprint;
import org.springframework.stereotype.Component;

@Component
public class FabricaSprint {
	
	public Sprint crear(ComandoSprint comandoSprint) {
	    return new Sprint(
	    	comandoSprint.getId(),
	        comandoSprint.getNombre(),
			comandoSprint.getFechaInicial(),
			comandoSprint.getFechaFinal(),
			comandoSprint.getDiasHabiles(),
			comandoSprint.getNumeroPersonas(),
			comandoSprint.getIdProyecto()
	    );
	}

}
