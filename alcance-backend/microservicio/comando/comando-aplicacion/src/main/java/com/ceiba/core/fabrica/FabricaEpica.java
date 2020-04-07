package com.ceiba.core.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.core.comando.ComandoEpica;
import com.ceiba.core.modelo.Epica;

@Component
public class FabricaEpica {
    public Epica crear(ComandoEpica comandoEpica){
        return new Epica(
                comandoEpica.getId(),
                comandoEpica.getTitulo(),
                comandoEpica.getEstimacion_comercial()
        );
    }
}
