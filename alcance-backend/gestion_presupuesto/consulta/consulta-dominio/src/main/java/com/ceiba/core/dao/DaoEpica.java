package com.ceiba.core.dao;

import com.ceiba.core.modelo.epica.DtoEpica;

import java.util.List;

public interface DaoEpica {

    /**
     * Permite listar epicas
     * @return listado de epicas
     */
    List<DtoEpica> listar();
}
