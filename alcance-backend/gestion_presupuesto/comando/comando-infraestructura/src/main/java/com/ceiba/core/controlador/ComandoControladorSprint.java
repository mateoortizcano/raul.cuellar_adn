package com.ceiba.core.controlador;

import com.ceiba.core.aplicacion.ComandoRespuesta;
import com.ceiba.core.comando.ComandoSprint;
import com.ceiba.core.manejador.sprint.ManejadorActualizarSprint;
import com.ceiba.core.manejador.sprint.ManejadorCrearSprint;
import com.ceiba.core.manejador.sprint.ManejadorEliminarSprint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sprints")
@Api(tags = { "Controlador comando sprint"})
public class ComandoControladorSprint {

	private final ManejadorActualizarSprint manejadorActualizarSprint;
	private final ManejadorCrearSprint manejadorCrearSprint;
	private final ManejadorEliminarSprint manejadorEliminarSprint;

	public ComandoControladorSprint(ManejadorActualizarSprint manejadorActualizarSprint, ManejadorCrearSprint manejadorCrearSprint, ManejadorEliminarSprint manejadorEliminarSprint) {
		this.manejadorActualizarSprint = manejadorActualizarSprint;
		this.manejadorCrearSprint = manejadorCrearSprint;
		this.manejadorEliminarSprint = manejadorEliminarSprint;
	}

	@PostMapping
	@ApiOperation("Crear sprint")
	public ComandoRespuesta<Long> crear(@RequestBody ComandoSprint comandoSprint) {
		return manejadorCrearSprint.ejecutar(comandoSprint);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Sprint")
	public void actualizar(@RequestBody ComandoSprint comandoSprint, @PathVariable Long id) {
		comandoSprint.setId(id);
		manejadorActualizarSprint.ejecutar(comandoSprint);
	}

	@DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Presupuesto")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarSprint.ejecutar(id);
	}
}
