package com.ceiba.core.repositorio;

import com.ceiba.core.modelo.PresupuestoSprint;

import java.util.List;

public interface RepositorioPresupuestoSprint {

    /**
    * Permite crear un presupuesto para sprint
    * @param presupuestoSprint
    * @return el id generado
    */
    Long crear(PresupuestoSprint presupuestoSprint);

    /**
     * Permite actualizar un presupuesto para sprint
     * @param presupuestoSprint
     */
    void actualizar(PresupuestoSprint presupuestoSprint);

    /**
     * Permite eliminar los presupuesto del Sprint no usados
     * @param idSprint
     * @param id
     */
    void eliminar(Long idSprint, List<Long> id);
}
