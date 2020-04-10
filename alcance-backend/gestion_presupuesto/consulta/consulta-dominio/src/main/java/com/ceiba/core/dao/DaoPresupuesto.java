package com.ceiba.core.dao;

import com.ceiba.core.modelo.DtoPresupuesto;
import com.ceiba.core.modelo.DtoPresupuestoGlobal;

import java.util.List;

public interface DaoPresupuesto {
    /**
     * Permite listar presupuestos
     * @return los presupuestos
     */
    List<DtoPresupuesto> listar();

    /**
     * Permite listar presupuestos
     * @return el presupuesto global de un proyecto
     */
    List<DtoPresupuestoGlobal> listarGlobal(Long idProyecto);
}
