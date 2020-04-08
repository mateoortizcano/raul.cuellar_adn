package com.ceiba.core.controlador;

import com.ceiba.core.comando.ComandoSprint;
import com.ceiba.core.manejador.sprint.ManejadorActualizarSprint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sprint")
@Api(tags = { "Controlador comando sprint"})
public class ComandoControladorSprint {

	private final ManejadorActualizarSprint manejadorActualizarSprint;

	@Autowired
	public ComandoControladorSprint(ManejadorActualizarSprint manejadorActualizarSprint) {
		this.manejadorActualizarSprint = manejadorActualizarSprint;
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Sprint")
	public void actualizar(@RequestBody ComandoSprint comandoSprint, @PathVariable Long id) {
		comandoSprint.setId(id);
		manejadorActualizarSprint.ejecutar(comandoSprint);
	}
}
