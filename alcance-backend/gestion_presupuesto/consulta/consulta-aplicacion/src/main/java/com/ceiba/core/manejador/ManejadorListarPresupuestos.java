package com.ceiba.core.manejador;

import com.ceiba.core.dao.DaoPresupuesto;
import com.ceiba.core.modelo.DtoPresupuesto;
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
