package com.ceiba.core.dao;

import com.ceiba.core.modelo.proyecto.DtoProyecto;
import com.ceiba.core.modelo.proyecto.DtoProyectoResumen;

import java.util.List;

public interface DaoProyecto {

    /**
     * Permite listar resumen de proyectos
     * @return listado proyectos
     */
    List<DtoProyecto> listar();

    /**
     * Permite listar resumen de proyectos
     * @return listado proyectos
     */
    List<DtoProyectoResumen> listarResumen();
}
