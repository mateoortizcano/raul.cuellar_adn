package com.ceiba.core.fabrica.epica;

import com.ceiba.core.comando.epica.ComandoEpica;
import com.ceiba.core.modelo.epica.Epica;
import org.springframework.stereotype.Component;

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
