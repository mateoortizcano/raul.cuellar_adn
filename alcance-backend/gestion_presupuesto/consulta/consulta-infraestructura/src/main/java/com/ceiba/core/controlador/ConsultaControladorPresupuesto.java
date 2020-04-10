package com.ceiba.core.controlador;

import com.ceiba.core.manejador.ManejadorListarPresupuestos;
import com.ceiba.core.manejador.ManejadorListarPresupuestosGlobal;
import com.ceiba.core.modelo.DtoPresupuesto;
import com.ceiba.core.modelo.DtoPresupuestoGlobal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/presupuestos")
@Api(tags={"Controlador consulta presupuesto"})
public class ConsultaControladorPresupuesto {

	private final ManejadorListarPresupuestos manejadorListarPresupuestos;
	private ManejadorListarPresupuestosGlobal manejadorListarPresupuestosGlobal;

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
	@RequestMapping("/global/{idProyecto}")
	public List<DtoPresupuestoGlobal> listarGlobal(@PathVariable Long idProyecto) {
		return this.manejadorListarPresupuestosGlobal.ejecutar(idProyecto);
	}
}
