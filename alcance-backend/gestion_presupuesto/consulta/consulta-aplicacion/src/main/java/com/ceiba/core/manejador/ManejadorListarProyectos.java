package com.ceiba.core.manejador;

import com.ceiba.core.dao.DaoProyecto;
import com.ceiba.core.modelo.proyecto.DtoProyecto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarProyectos {

    private final DaoProyecto daoProyecto;

    public ManejadorListarProyectos(DaoProyecto daoProyecto) {
        this.daoProyecto = daoProyecto;
    }

    public List<DtoProyecto> ejecutar(){
        return this.daoProyecto.listar();
    }
}
