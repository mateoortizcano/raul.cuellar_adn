package com.ceiba.core.manejador;

import com.ceiba.core.dao.DaoEpica;
import com.ceiba.core.modelo.DtoEpica;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarEpicas {

    private final DaoEpica daoEpica;

    public ManejadorListarEpicas(DaoEpica daoEpica) {
        this.daoEpica = daoEpica;
    }

    public List<DtoEpica> ejecutar(){
        return this.daoEpica.listar();
    }

}
