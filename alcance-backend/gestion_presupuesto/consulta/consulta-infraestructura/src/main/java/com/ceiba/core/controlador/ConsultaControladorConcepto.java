package com.ceiba.core.controlador;

import com.ceiba.core.manejador.concepto.ManejadorListarConceptos;
import com.ceiba.core.modelo.concepto.DtoConcepto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/proyectos/{idProyecto}/conceptos")
@Api(tags={"Controlador consulta conceptos"})
public class ConsultaControladorConcepto {
    private final ManejadorListarConceptos manejadorListarConceptos;

    public ConsultaControladorConcepto(ManejadorListarConceptos manejadorListarConceptos) {
        this.manejadorListarConceptos = manejadorListarConceptos;
    }

    @GetMapping
    @ApiOperation("Listar conceptos")
    public List<DtoConcepto> listar(@PathVariable Long idProyecto){
        return this.manejadorListarConceptos.ejecutar(idProyecto);
    }

}
