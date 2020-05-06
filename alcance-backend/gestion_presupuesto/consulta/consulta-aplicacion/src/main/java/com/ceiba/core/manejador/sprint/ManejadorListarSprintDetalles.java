package com.ceiba.core.manejador.sprint;

import com.ceiba.core.dao.DaoSprint;
import com.ceiba.core.modelo.sprint.DtoSprintDetalles;
import org.springframework.stereotype.Component;

@Component
public class ManejadorListarSprintDetalles {

    private final DaoSprint daoSprint;

    public ManejadorListarSprintDetalles(DaoSprint daoSprint) {
        this.daoSprint = daoSprint;
    }

    public DtoSprintDetalles ejecutar(Long id){
        return this.daoSprint.listarDetalles(id);
    }
}
