package com.ceiba.core.manejador.proyecto;

import com.ceiba.core.dao.DaoProyecto;
import com.ceiba.core.modelo.proyecto.DtoProyectoResumen;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarProyectosResumen {

    private final DaoProyecto daoProyecto;

    public ManejadorListarProyectosResumen(DaoProyecto daoProyecto) {
        this.daoProyecto = daoProyecto;
    }

    public List<DtoProyectoResumen> ejecutar(){
        return this.daoProyecto.listarResumen();
    }
}
