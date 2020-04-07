package com.ceiba.core.fabrica;

import com.ceiba.core.comando.ComandoPresupuesto;
import com.ceiba.core.modelo.Presupuesto;
import org.springframework.stereotype.Component;

@Component
public class FabricaPresupuesto {
    public Presupuesto crear(ComandoPresupuesto comandoPresupuesto){
        return new Presupuesto(
                comandoPresupuesto.getId(),
                comandoPresupuesto.getValor(),
                comandoPresupuesto.getReserva_estabilizacion(),
                comandoPresupuesto.getObservaciones()
        );
    }
}
