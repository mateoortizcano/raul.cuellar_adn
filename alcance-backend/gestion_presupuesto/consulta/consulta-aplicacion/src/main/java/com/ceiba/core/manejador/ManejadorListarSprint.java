package com.ceiba.core.manejador;

import com.ceiba.core.dao.DaoSprint;
import com.ceiba.core.modelo.DtoSprint;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarSprint {

    private final DaoSprint daoSprint;

    public ManejadorListarSprint(DaoSprint daoSprint) {
        this.daoSprint = daoSprint;
    }

    public List<DtoSprint> ejecutar(Long idProyecto){
        return this.daoSprint.listar(idProyecto);
    }
}
