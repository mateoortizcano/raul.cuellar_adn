package com.ceiba.core.controlador;

import com.ceiba.core.manejador.concepto.ManejadorListarConceptos;
import com.ceiba.core.modelo.concepto.DtoConcepto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@RestController
@RequestMapping("/proyectos/{idProyecto}/conceptos/{fechaInicial}")
@Api(tags={"Controlador consulta conceptos"})
public class ConsultaControladorConcepto {
    private final ManejadorListarConceptos manejadorListarConceptos;

    public ConsultaControladorConcepto(ManejadorListarConceptos manejadorListarConceptos) {
        this.manejadorListarConceptos = manejadorListarConceptos;
    }

    @GetMapping
    @ApiOperation("Listar conceptos")
    public List<DtoConcepto> listar(@PathVariable Long idProyecto,
                                    @PathVariable Long fechaInicial){
        return this.manejadorListarConceptos.ejecutar(
                idProyecto,
                LocalDateTime.ofEpochSecond(fechaInicial, 0, ZoneOffset.UTC));
    }

}
