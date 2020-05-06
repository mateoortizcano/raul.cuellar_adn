package com.ceiba.core.manejador;

import com.ceiba.core.dao.DaoConcepto;
import com.ceiba.core.modelo.concepto.DtoConcepto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarConceptos {

    private final DaoConcepto daoConcepto;

    public ManejadorListarConceptos(DaoConcepto daoConcepto) {
        this.daoConcepto = daoConcepto;
    }

    public List<DtoConcepto> ejecutar(Long idProyecto){
        return this.daoConcepto.listar(idProyecto);
    }
}
