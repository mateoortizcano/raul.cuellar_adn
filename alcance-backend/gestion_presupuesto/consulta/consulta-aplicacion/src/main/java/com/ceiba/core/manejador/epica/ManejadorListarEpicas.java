package com.ceiba.core.manejador.epica;

import com.ceiba.core.dao.DaoEpica;
import com.ceiba.core.modelo.epica.DtoEpica;
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
