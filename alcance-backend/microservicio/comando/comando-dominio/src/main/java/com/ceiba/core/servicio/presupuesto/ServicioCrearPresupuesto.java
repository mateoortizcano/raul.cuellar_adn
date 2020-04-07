package com.ceiba.core.servicio.presupuesto;

import com.ceiba.core.modelo.Presupuesto;
import com.ceiba.core.repositorio.RepositorioPresupuesto;

public class ServicioCrearPresupuesto {
    private RepositorioPresupuesto repositorioPresupuesto;

    public ServicioCrearPresupuesto(RepositorioPresupuesto repositorioPresupuesto) {
        this.repositorioPresupuesto = repositorioPresupuesto;
    }

    public Long ejecutar(Presupuesto presupuesto){
        return this.repositorioPresupuesto.crear(presupuesto);
    }
}
