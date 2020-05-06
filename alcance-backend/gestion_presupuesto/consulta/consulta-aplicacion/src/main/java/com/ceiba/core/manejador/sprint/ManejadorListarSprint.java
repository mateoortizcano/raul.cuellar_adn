package com.ceiba.core.manejador.sprint;

import com.ceiba.core.dao.DaoSprint;
import com.ceiba.core.modelo.sprint.DtoSprint;
import org.springframework.stereotype.Component;

@Component
public class ManejadorListarSprint {

    private final DaoSprint daoSprint;

    public ManejadorListarSprint(DaoSprint daoSprint) {
        this.daoSprint = daoSprint;
    }

    public DtoSprint ejecutar(Long idProyecto, Long id){
        return this.daoSprint.consultar(idProyecto, id);
    }
}
