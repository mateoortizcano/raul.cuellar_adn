package com.ceiba.core.controlador;

import com.ceiba.core.manejador.ManejadorListarSprint;
import com.ceiba.core.modelo.DtoSprint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/proyectos/{idProyecto}/sprints")
@Api(tags={"Controlador consulta sprint"})
public class ConsultaControladorSprint {

	private final ManejadorListarSprint manejadorListarSprint;

	public ConsultaControladorSprint(ManejadorListarSprint manejadorListarSprint) {
		this.manejadorListarSprint = manejadorListarSprint;
	}

	@GetMapping
	@ApiOperation("Listar Presupuestos")
	public List<DtoSprint> listar(@PathVariable Long idProyecto) {
		return this.manejadorListarSprint.ejecutar(idProyecto);
	}

}
