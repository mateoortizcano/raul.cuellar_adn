package com.ceiba.core.dao;

import com.ceiba.core.modelo.concepto.DtoConcepto;

import java.util.List;

public interface DaoConcepto {

    /**
     * Permite listar conceptos
     * @return listado conceptos
     */
    List<DtoConcepto> listar();
}
