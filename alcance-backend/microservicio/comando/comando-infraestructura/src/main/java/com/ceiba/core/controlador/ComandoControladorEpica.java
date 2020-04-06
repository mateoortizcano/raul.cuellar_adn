package com.ceiba.core.controlador;

import com.ceiba.core.aplicacion.ComandoRespuesta;
import com.ceiba.core.comando.epica.ComandoEpica;
import com.ceiba.core.manejador.epica.ManejadorCrearEpica;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/epicas")
@Api(tags = { "Controlador comando usuario"})
public class ComandoControladorEpica {
    private ManejadorCrearEpica manejadorCrearEpica;

    @Autowired
    public ComandoControladorEpica(ManejadorCrearEpica manejadorCrearEpica) {
        this.manejadorCrearEpica = manejadorCrearEpica;
    }

    @PostMapping
    @ApiOperation("Crear Usuario")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoEpica comandoEpica){
        return manejadorCrearEpica.ejecutar(comandoEpica);
    }

}
