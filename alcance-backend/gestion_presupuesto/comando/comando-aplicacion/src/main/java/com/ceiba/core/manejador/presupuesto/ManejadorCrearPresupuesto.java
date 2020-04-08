package com.ceiba.core.manejador.presupuesto;

import com.ceiba.core.aplicacion.ComandoRespuesta;
import com.ceiba.core.aplicacion.manejador.ManejadorComandoRespuesta;
import com.ceiba.core.comando.ComandoPresupuesto;
import com.ceiba.core.fabrica.FabricaPresupuesto;
import com.ceiba.core.modelo.Presupuesto;
import com.ceiba.core.repositorio.RepositorioPresupuesto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPresupuesto implements ManejadorComandoRespuesta<ComandoPresupuesto, ComandoRespuesta<Long>> {

    private final FabricaPresupuesto fabricaPresupuesto;
    private final RepositorioPresupuesto repositorioPresupuesto;

    public ManejadorCrearPresupuesto(FabricaPresupuesto fabricaPresupuesto, RepositorioPresupuesto repositorioPresupuesto) {
        this.fabricaPresupuesto = fabricaPresupuesto;
        this.repositorioPresupuesto = repositorioPresupuesto;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoPresupuesto comandoPresupuesto){
        Presupuesto presupuesto = this.fabricaPresupuesto.crear(comandoPresupuesto);
        return new ComandoRespuesta<>(this.repositorioPresupuesto.crear(presupuesto));
    }
}
