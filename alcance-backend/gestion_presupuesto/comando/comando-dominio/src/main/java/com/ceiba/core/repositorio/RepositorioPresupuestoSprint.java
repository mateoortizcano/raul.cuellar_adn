package com.ceiba.core.repositorio;

import com.ceiba.core.modelo.PresupuestoSprint;

public interface RepositorioPresupuestoSprint {

    /**
    * Permite crear un presupuesto por sprint
    * @param presupuestoSprint
    * @return el id generado
    */
    Long crear(PresupuestoSprint presupuestoSprint);
}
