package com.ceiba.core.servicio.presupuesto;

import com.ceiba.core.BasePrueba;
import com.ceiba.core.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.core.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.core.servicio.testdatabuilder.PresupuestoSprintTestDataBuilder;
import com.ceiba.core.servicio.testdatabuilder.PresupuestoTestDataBuilder;
import org.junit.Test;

public class PresupuestoSprintTest {

    @Test
    public void validarHorasPlaneadasNegativas() {
        // arrange
        PresupuestoSprintTestDataBuilder presupuestoSprintTestDataBuilder = new PresupuestoSprintTestDataBuilder(
                1L,
                1L,
                1L,
                -180.0,
                18000000.0,
                10.0,
                1500000.0
        );
        // act - assert
        BasePrueba.assertThrows(() -> presupuestoSprintTestDataBuilder.build(),
                ExcepcionValorInvalido.class, "Proporcione un valor válido para las horas planeadas");
    }
    @Test
    public void validarHorasEjecutadasNegativas() {
        // arrange
        PresupuestoSprintTestDataBuilder presupuestoSprintTestDataBuilder = new PresupuestoSprintTestDataBuilder(
                1L,
                1L,
                1L,
                180.0,
                -10.0,
                18000000.0,
                1500000.0
        );
        // act - assert
        BasePrueba.assertThrows(() -> presupuestoSprintTestDataBuilder.build(),
                ExcepcionValorInvalido.class, "Proporcione un valor válido para las horas ejecutadas");
    }
    @Test
    public void validarValorPlaneadoNegativo() {
        // arrange
        PresupuestoSprintTestDataBuilder presupuestoSprintTestDataBuilder = new PresupuestoSprintTestDataBuilder(
                1L,
                1L,
                1L,
                180.0,
                10.0,
                -18000000.0,
                1500000.0
        );
        // act - assert
        BasePrueba.assertThrows(() -> presupuestoSprintTestDataBuilder.build(),
                ExcepcionValorInvalido.class, "Proporcione un valor válido para el valor planeado");
    }
    @Test
    public void validarValorEjecutadoNegativo() {
        // arrange
        PresupuestoSprintTestDataBuilder presupuestoSprintTestDataBuilder = new PresupuestoSprintTestDataBuilder(
                1L,
                1L,
                1L,
                180.0,
                10.0,
                18000000.0,
                -1500000.0
        );
        // act - assert
        BasePrueba.assertThrows(() -> presupuestoSprintTestDataBuilder.build(),
                ExcepcionValorInvalido.class, "Proporcione un valor válido para el valor ejecutado");
    }
}
