package com.ceiba.core.repositorio;

import com.ceiba.core.modelo.Presupuesto;

public interface RepositorioPresupuesto {
    /**
     * Permite crear un presupuesto
     * @param presupuesto
     * @return el id generado
     */
    Long crear(Presupuesto presupuesto);

    /**
     * Permite eliminar un presupuesto
     * @param id
     */
    void eliminar(Long id);
}
