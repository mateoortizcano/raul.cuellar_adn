package com.ceiba.core.dao;

import com.ceiba.core.modelo.sprint.DtoSprint;
import com.ceiba.core.modelo.sprint.DtoSprintResumen;

import java.util.List;

public interface DaoSprint {

    /**
     * Permite listar sprint
     * @return listado de sprints
     */
    List<DtoSprint> listar(Long idProyecto);

    /**
     * Permite consultar un sprint
     * @return sprint
     */
    DtoSprint consultar(Long idProyecto, Long id);

    /**
     * Permite consultar un sprint
     * @return sprint
     */
    List<DtoSprintResumen> listarResumen(Long idProyecto);
}
