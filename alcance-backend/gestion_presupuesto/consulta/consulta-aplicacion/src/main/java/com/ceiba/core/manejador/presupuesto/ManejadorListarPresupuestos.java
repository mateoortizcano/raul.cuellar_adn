package com.ceiba.core.manejador.presupuesto;

import com.ceiba.core.dao.DaoPresupuesto;
import com.ceiba.core.modelo.presupuesto.DtoPresupuesto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPresupuestos {

    private final DaoPresupuesto daoPresupuesto;

    public ManejadorListarPresupuestos(DaoPresupuesto daoPresupuesto) {
        this.daoPresupuesto = daoPresupuesto;
    }

    public List<DtoPresupuesto> ejecutar(){
        return this.daoPresupuesto.listar();
    }

}
