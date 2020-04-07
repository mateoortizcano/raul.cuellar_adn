package com.ceiba.core.manejador.epica;

import org.springframework.stereotype.Component;

import com.ceiba.core.aplicacion.ComandoRespuesta;
import com.ceiba.core.aplicacion.manejador.ManejadorComandoRespuesta;
import com.ceiba.core.comando.ComandoEpica;
import com.ceiba.core.fabrica.FabricaEpica;
import com.ceiba.core.modelo.Epica;
import com.ceiba.core.servicio.epica.ServicioCrearEpica;

@Component
public class ManejadorCrearEpica  implements ManejadorComandoRespuesta<ComandoEpica, ComandoRespuesta<Long>> {

    private final FabricaEpica fabricaEpica;
    private final ServicioCrearEpica servicioCrearEpica;

    public ManejadorCrearEpica(FabricaEpica fabricaEpica, ServicioCrearEpica servicioCrearEpica) {
        this.fabricaEpica = fabricaEpica;
        this.servicioCrearEpica = servicioCrearEpica;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoEpica comandoEpica){
        Epica epica = this.fabricaEpica.crear(comandoEpica);
        return new ComandoRespuesta<>(this.servicioCrearEpica.ejecutar(epica));
    }
}
