package com.ceiba.core.controlador;

import static com.ceiba.core.dominio.util.fechas.FechaUtil.diasEntreDosFechasSinContarFestivosNiFinesDeSemana;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/calendario")
@Api(tags={"Controlador consulta calendario"})
public class ConsultaControladorCalendario {
    
    @PostMapping
    @ApiOperation("Consultar días hábiles")
    public Integer diasFestivos(@RequestBody ConsultaCalendario consultaCalendario){
        return diasEntreDosFechasSinContarFestivosNiFinesDeSemana(
                consultaCalendario.getFechaInicial(),
                consultaCalendario.getFechaFinal());
    }
}
