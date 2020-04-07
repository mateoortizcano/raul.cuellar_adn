package com.ceiba.core.dao;

import com.ceiba.core.modelo.DtoPresupuesto;

import java.util.List;

public interface DaoPresupuesto {
    /**
     * Permite listar presupuestos
     * @return los presupuestos
     */
    List<DtoPresupuesto> listar();
}
