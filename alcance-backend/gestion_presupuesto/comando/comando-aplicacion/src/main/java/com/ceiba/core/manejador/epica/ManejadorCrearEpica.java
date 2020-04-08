package com.ceiba.core.manejador.epica;

import com.ceiba.core.repositorio.RepositorioEpica;
import org.springframework.stereotype.Component;

import com.ceiba.core.aplicacion.ComandoRespuesta;
import com.ceiba.core.aplicacion.manejador.ManejadorComandoRespuesta;
import com.ceiba.core.comando.ComandoEpica;
import com.ceiba.core.fabrica.FabricaEpica;
import com.ceiba.core.modelo.Epica;

@Component
public class ManejadorCrearEpica  implements ManejadorComandoRespuesta<ComandoEpica, ComandoRespuesta<Long>> {

    private final FabricaEpica fabricaEpica;
    private final RepositorioEpica repositorioEpica;

    public ManejadorCrearEpica(FabricaEpica fabricaEpica, RepositorioEpica repositorioEpica) {
        this.fabricaEpica = fabricaEpica;
        this.repositorioEpica = repositorioEpica;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoEpica comandoEpica){
        Epica epica = this.fabricaEpica.crear(comandoEpica);
        return new ComandoRespuesta<>(this.repositorioEpica.crear(epica));
    }
}
