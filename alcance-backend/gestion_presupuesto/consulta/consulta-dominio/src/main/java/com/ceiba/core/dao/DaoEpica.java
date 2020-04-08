package com.ceiba.core.dao;

import com.ceiba.core.modelo.DtoEpica;

import java.util.List;

public interface DaoEpica {

    /**
     * Permite listar epicas
     * @return listado de epicas
     */
    List<DtoEpica> listar();
}
