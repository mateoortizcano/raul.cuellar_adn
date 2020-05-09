package com.ceiba.core.fabrica;

import com.ceiba.core.comando.ComandoConcepto;
import com.ceiba.core.modelo.PresupuestoSprint;
import org.springframework.stereotype.Component;

@Component
public class FabricaPresupuestoSprint {
    public PresupuestoSprint crear(Long idSprint, ComandoConcepto concepto){
        return new PresupuestoSprint(
                0L,
                idSprint,
                concepto.getId(),
                concepto.getHorasSugeridas(),
                0.0,
                concepto.getValorSugerido(),
                0.0
        );
    }
}
