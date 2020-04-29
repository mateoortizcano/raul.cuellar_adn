package com.ceiba.core.manejador;

import com.ceiba.core.dao.DaoPresupuestoSprint;
import com.ceiba.core.dao.DaoSprint;
import com.ceiba.core.modelo.DtoSprintResumen;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarSprintsResumen {

    private final DaoSprint daoSprint;
    private final DaoPresupuestoSprint daoPresupuestoSprint;

    public ManejadorListarSprintsResumen(DaoSprint daoSprint, DaoPresupuestoSprint daoPresupuestoSprint) {
        this.daoSprint = daoSprint;
        this.daoPresupuestoSprint = daoPresupuestoSprint;
    }

    public List<DtoSprintResumen> ejecutar(Long idProyecto){
        List<DtoSprintResumen> sprintResumen = this.daoSprint.listarResumen(idProyecto);
        for (DtoSprintResumen sprint:sprintResumen ){
            sprint.setPresupuestosSprint(
                    this.daoPresupuestoSprint.listar(sprint.getId()));
        }
        return sprintResumen;
    }
}
