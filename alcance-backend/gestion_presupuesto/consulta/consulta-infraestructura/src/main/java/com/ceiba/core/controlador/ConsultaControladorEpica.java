package com.ceiba.core.controlador;

import com.ceiba.core.manejador.ManejadorListarEpicas;
import com.ceiba.core.modelo.DtoEpica;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/epicas")
@Api(tags={"Controlador consulta epicas"})
public class ConsultaControladorEpica {
    private final ManejadorListarEpicas manejadorListarEpicas;

    public ConsultaControladorEpica(ManejadorListarEpicas manejadorListarEpicas) {
        this.manejadorListarEpicas = manejadorListarEpicas;
    }

    @GetMapping
    @ApiOperation("Listar epicas")
    public List<DtoEpica> listar(){
        return this.manejadorListarEpicas.ejecutar();
    }
}
