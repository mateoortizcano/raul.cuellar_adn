package com.ceiba.core.manejador.concepto;

import com.ceiba.core.dao.DaoConcepto;
import com.ceiba.core.modelo.concepto.DtoConcepto;
import jdk.vm.ci.meta.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ManejadorListarConceptos {

    private final DaoConcepto daoConcepto;

    public ManejadorListarConceptos(DaoConcepto daoConcepto) {
        this.daoConcepto = daoConcepto;
    }

    public List<DtoConcepto> ejecutar(Long idProyecto, LocalDateTime fechaInicial, LocalDateTime fechaFinal){
        return this.daoConcepto.listar(idProyecto, fechaInicial, fechaFinal);
    }
}
