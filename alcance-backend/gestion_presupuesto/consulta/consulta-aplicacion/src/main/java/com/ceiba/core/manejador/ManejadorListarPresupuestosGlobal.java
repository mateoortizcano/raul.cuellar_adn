package com.ceiba.core.manejador;

import com.ceiba.core.dao.DaoPresupuesto;
import com.ceiba.core.modelo.presupuesto.DtoPresupuestoGlobal;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPresupuestosGlobal {

    private final DaoPresupuesto daoPresupuesto;

    public ManejadorListarPresupuestosGlobal(DaoPresupuesto daoPresupuesto) {
        this.daoPresupuesto = daoPresupuesto;
    }

    public List<DtoPresupuestoGlobal> ejecutar(Long idProyecto){
        return this.daoPresupuesto.listarGlobal(idProyecto);
    }
}
