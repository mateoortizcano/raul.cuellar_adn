package com.ceiba.core.controlador;

import com.ceiba.core.manejador.ManejadorListarProyectos;
import com.ceiba.core.manejador.ManejadorListarProyectosResumen;
import com.ceiba.core.modelo.proyecto.DtoProyecto;
import com.ceiba.core.modelo.proyecto.DtoProyectoResumen;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/proyectos")
@Api(tags={"Controlador consulta proyectos"})
public class ConsultaControladorProyecto {
    private final ManejadorListarProyectos manejadorListarProyectos;
    private final ManejadorListarProyectosResumen manejadorListarProyectosResumen;

    public ConsultaControladorProyecto(ManejadorListarProyectos manejadorListarProyectos, ManejadorListarProyectosResumen manejadorListarProyectosResumen) {
        this.manejadorListarProyectos = manejadorListarProyectos;
        this.manejadorListarProyectosResumen = manejadorListarProyectosResumen;
    }

    @GetMapping
    @ApiOperation("Listar proyectos")
    public List<DtoProyecto> listar(){
        return this.manejadorListarProyectos.ejecutar();
    }

    @GetMapping
    @ApiOperation("Listar proyectos")
    @RequestMapping(path = "/resumen", method = RequestMethod.GET)
    public List<DtoProyectoResumen> listarResumen(){
        return this.manejadorListarProyectosResumen.ejecutar();
    }
}
