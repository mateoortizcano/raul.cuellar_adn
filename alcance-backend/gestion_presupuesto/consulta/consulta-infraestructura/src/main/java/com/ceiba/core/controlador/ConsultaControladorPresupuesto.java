package com.ceiba.core.controlador;

import com.ceiba.core.manejador.ManejadorListarPresupuestos;
import com.ceiba.core.modelo.DtoPresupuesto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/presupuestos")
@Api(tags={"Controlador consulta presupuesto"})
public class ConsultaControladorPresupuesto {

	private final ManejadorListarPresupuestos manejadorListarPresupuestos;

	public ConsultaControladorPresupuesto(ManejadorListarPresupuestos manejadorListarPresupuestos) {
		this.manejadorListarPresupuestos = manejadorListarPresupuestos;
	}

	@GetMapping
	@ApiOperation("Listar Presupuestos")
	public List<DtoPresupuesto> listar() {
		return this.manejadorListarPresupuestos.ejecutar();
	}

}
