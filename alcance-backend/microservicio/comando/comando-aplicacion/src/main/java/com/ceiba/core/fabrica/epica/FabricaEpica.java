package com.ceiba.core.fabrica.epica;

import org.springframework.stereotype.Component;

import com.ceiba.core.comando.epica.ComandoEpica;
import com.ceiba.core.modelo.epica.Epica;

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
