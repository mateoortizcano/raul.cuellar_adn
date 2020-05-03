package com.ceiba.core.manejador;

import com.ceiba.core.dao.DaoSprint;
import com.ceiba.core.modelo.sprint.DtoSprintResumen;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarSprintsResumen {

    private final DaoSprint daoSprint;

    public ManejadorListarSprintsResumen(DaoSprint daoSprint) {
        this.daoSprint = daoSprint;
    }

    public List<DtoSprintResumen> ejecutar(Long idProyecto){
        return this.daoSprint.listarResumen(idProyecto);
    }
}
