package com.ceiba.core.traductor;

import com.ceiba.core.modelo.presupuestosprint.DtoPresupuestoSprint;
import com.ceiba.core.modelo.sprint.DtoSprintDetalles;
import com.ceiba.core.modelo.sprint.DtoSprintJoinPresupuestos;

import java.util.ArrayList;
import java.util.List;

public final class SprintJoinPresupuestos {

    private SprintJoinPresupuestos(){}

    public static DtoSprintDetalles toSprintDetalles(List<DtoSprintJoinPresupuestos> sprintJoinPresupuestosList){
        List<DtoPresupuestoSprint> presupuestoSprintList = new ArrayList<>();
        for(DtoSprintJoinPresupuestos sprintJoinPresupuesto: sprintJoinPresupuestosList){
            if(sprintJoinPresupuesto.getIdPresupuesto() > 0){
                DtoPresupuestoSprint dtoPresupuestoSprint = new DtoPresupuestoSprint(
                        sprintJoinPresupuesto.getIdPresupuesto(),
                        sprintJoinPresupuesto.getIdSprint(),
                        sprintJoinPresupuesto.getIdConcepto(),
                        sprintJoinPresupuesto.getNombreConcepto(),
                        sprintJoinPresupuesto.getTarifaConcepto(),
                        sprintJoinPresupuesto.getTiempoCompletoConcepto(),
                        sprintJoinPresupuesto.getHorasPlaneadas(),
                        sprintJoinPresupuesto.getHorasEjecutadas(),
                        sprintJoinPresupuesto.getValorPlaneado(),
                        sprintJoinPresupuesto.getValorEjecutado()
                );
                presupuestoSprintList.add(dtoPresupuestoSprint);
            }
        }
        DtoSprintJoinPresupuestos sprintJoinPresupuestos0 = sprintJoinPresupuestosList.get(0);
        return new DtoSprintDetalles(
                sprintJoinPresupuestos0.getIdSprint(),
                sprintJoinPresupuestos0.getNombre(),
                sprintJoinPresupuestos0.getFechaInicial(),
                sprintJoinPresupuestos0.getFechaFinal(),
                sprintJoinPresupuestos0.getDiasHabiles(),
                sprintJoinPresupuestos0.getNumeroPersonas(),
                sprintJoinPresupuestos0.getIdProyecto(),
                presupuestoSprintList
        );
    }
}
