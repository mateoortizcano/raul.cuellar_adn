package com.ceiba.core.fabrica;

import com.ceiba.core.comando.ComandoPresupuestoSprint;
import com.ceiba.core.modelo.PresupuestoSprint;
import org.springframework.stereotype.Component;

@Component
public class FabricaPresupuestoSprint {
    public PresupuestoSprint crear(Long idSprint, ComandoPresupuestoSprint comandoPresupuestoSprint){
        return new PresupuestoSprint(
                comandoPresupuestoSprint.getId(),
                idSprint,
                comandoPresupuestoSprint.getIdConcepto(),
                comandoPresupuestoSprint.getHorasPlaneadas(),
                comandoPresupuestoSprint.getHorasEjecutadas(),
                comandoPresupuestoSprint.getValorPlaneado(),
                comandoPresupuestoSprint.getValorEjecutado()
        );
    }
}
