package com.ceiba.core.manejador;

import com.ceiba.core.dao.DaoSprint;
import com.ceiba.core.modelo.sprint.DtoSprint;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarSprints {

    private final DaoSprint daoSprint;

    public ManejadorListarSprints(DaoSprint daoSprint) {
        this.daoSprint = daoSprint;
    }

    public List<DtoSprint> ejecutar(Long idProyecto){
        return this.daoSprint.listar(idProyecto);
    }
}
