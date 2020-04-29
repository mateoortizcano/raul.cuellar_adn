package com.ceiba.core.dao;


import com.ceiba.core.modelo.DtoPresupuestoSprint;

import java.util.List;

public interface DaoPresupuestoSprint {
    /**
     * Permite listar presupuestos
     * @return los presupuestos para un sprint
     */
    List<DtoPresupuestoSprint> listar(Long idSprint);
}
