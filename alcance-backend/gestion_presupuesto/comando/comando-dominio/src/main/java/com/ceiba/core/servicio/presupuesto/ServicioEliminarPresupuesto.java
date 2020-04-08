package com.ceiba.core.servicio.presupuesto;

import com.ceiba.core.repositorio.RepositorioPresupuesto;

public class ServicioEliminarPresupuesto {

    private final RepositorioPresupuesto repositorioPresupuesto;

    public ServicioEliminarPresupuesto(RepositorioPresupuesto repositorioPresupuesto) {
        this.repositorioPresupuesto = repositorioPresupuesto;
    }

    public void ejecutar(Long id) {
        this.repositorioPresupuesto.eliminar(id);
    }
}
