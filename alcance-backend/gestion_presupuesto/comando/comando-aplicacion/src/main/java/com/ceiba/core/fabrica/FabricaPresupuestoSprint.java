package com.ceiba.core.fabrica;

import com.ceiba.core.modelo.PresupuestoSprint;
import org.springframework.stereotype.Component;

@Component
public class FabricaPresupuestoSprint {
    public PresupuestoSprint crear(Long idSprint, Long concepto){
        return new PresupuestoSprint(
                0L,
                idSprint,
                concepto,
                0.0,
                0.0,
                0.0,
                0.0
        );
    }
}
