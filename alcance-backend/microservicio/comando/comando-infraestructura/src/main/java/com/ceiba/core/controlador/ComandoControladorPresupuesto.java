package com.ceiba.core.controlador;

import com.ceiba.core.aplicacion.ComandoRespuesta;
import com.ceiba.core.comando.ComandoPresupuesto;
import com.ceiba.core.manejador.presupuesto.ManejadorCrearPresupuesto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/presupuestos")
@Api(tags = { "Controlador comando presupuestos"})
public class ComandoControladorPresupuesto {
    private ManejadorCrearPresupuesto manejadorCrearPresupuesto;

    @Autowired
    public ComandoControladorPresupuesto(ManejadorCrearPresupuesto manejadorCrearPresupuesto) {
        this.manejadorCrearPresupuesto = manejadorCrearPresupuesto;
    }

    @PostMapping
    @ApiOperation("Crear Presupuesto")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPresupuesto comandoPresupuesto){
        return manejadorCrearPresupuesto.ejecutar(comandoPresupuesto);
    }

}
