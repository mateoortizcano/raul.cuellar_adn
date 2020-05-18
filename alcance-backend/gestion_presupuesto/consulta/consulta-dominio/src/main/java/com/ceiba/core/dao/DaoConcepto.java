package com.ceiba.core.dao;

import com.ceiba.core.modelo.concepto.DtoConcepto;

import java.time.LocalDateTime;
import java.util.List;

public interface DaoConcepto {

    /**
     * Permite listar conceptos
     * @param idProyecto
     * @return listado conceptos
     */
    List<DtoConcepto> listar(Long idProyecto, LocalDateTime fechaInicial);

}
