package com.ceiba.core.controlador;

import com.ceiba.core.aplicacion.ComandoRespuesta;
import com.ceiba.core.comando.ComandoPresupuesto;
import com.ceiba.core.manejador.presupuesto.ManejadorCrearPresupuesto;
import com.ceiba.core.manejador.presupuesto.ManejadorEliminarPresupuesto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/presupuestos")
@Api(tags = { "Controlador comando presupuestos"})
public class ComandoControladorPresupuesto {
    private ManejadorCrearPresupuesto manejadorCrearPresupuesto;
    private ManejadorEliminarPresupuesto manejadorEliminarPresupuesto;

    @Autowired
    public ComandoControladorPresupuesto(ManejadorCrearPresupuesto manejadorCrearPresupuesto, ManejadorEliminarPresupuesto manejadorEliminarPresupuesto) {
        this.manejadorCrearPresupuesto = manejadorCrearPresupuesto;
        this.manejadorEliminarPresupuesto = manejadorEliminarPresupuesto;
    }

    @PostMapping
    @ApiOperation("Crear Presupuesto")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPresupuesto comandoPresupuesto){
        return manejadorCrearPresupuesto.ejecutar(comandoPresupuesto);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Presupuesto")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarPresupuesto.ejecutar(id);
    }
}
