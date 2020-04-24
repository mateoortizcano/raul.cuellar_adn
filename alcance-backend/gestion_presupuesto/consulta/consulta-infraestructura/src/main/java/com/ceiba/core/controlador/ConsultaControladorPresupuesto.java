package com.ceiba.core.controlador;

import com.ceiba.core.manejador.ManejadorListarPresupuestos;
import com.ceiba.core.manejador.ManejadorListarPresupuestosGlobal;
import com.ceiba.core.modelo.DtoPresupuesto;
import com.ceiba.core.modelo.DtoPresupuestoGlobal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/presupuestos")
@Api(tags={"Controlador consulta presupuesto"})
public class ConsultaControladorPresupuesto {

	private final ManejadorListarPresupuestos manejadorListarPresupuestos;
	private final ManejadorListarPresupuestosGlobal manejadorListarPresupuestosGlobal;

	public ConsultaControladorPresupuesto(ManejadorListarPresupuestos manejadorListarPresupuestos,
										  ManejadorListarPresupuestosGlobal manejadorListarPresupuestosGlobal) {
		this.manejadorListarPresupuestos = manejadorListarPresupuestos;
		this.manejadorListarPresupuestosGlobal = manejadorListarPresupuestosGlobal;
	}

	@GetMapping
	@ApiOperation("Listar Presupuestos")
	public List<DtoPresupuesto> listar() {
		return this.manejadorListarPresupuestos.ejecutar();
	}

	@GetMapping
	@ApiOperation("Listar Presupuestos")
	@RequestMapping(path = "/global/{idProyecto}", method = RequestMethod.GET)
	public List<DtoPresupuestoGlobal> listarGlobal(@PathVariable Long idProyecto) {
		return this.manejadorListarPresupuestosGlobal.ejecutar(idProyecto);
	}
}
