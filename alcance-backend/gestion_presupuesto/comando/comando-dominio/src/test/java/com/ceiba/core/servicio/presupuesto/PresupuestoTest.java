package com.ceiba.core.servicio.presupuesto;

import com.ceiba.core.BasePrueba;
import com.ceiba.core.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.core.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.core.modelo.Presupuesto;
import com.ceiba.core.repositorio.RepositorioPresupuesto;
import com.ceiba.core.servicio.testdatabuilder.PresupuestoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class PresupuestoTest {

    @Test
    public void validarValorNegativo() {
        // arrange
        PresupuestoTestDataBuilder presupuestoTestDataBuilder = new PresupuestoTestDataBuilder(-1.0, 10.0, "", 1);
        // act - assert
        BasePrueba.assertThrows(() -> presupuestoTestDataBuilder.build(), ExcepcionValorInvalido.class, "Proporcione un valor válido para el presupuesto");
    }

    @Test
    public void validarValorCero() {
        // arrange
        PresupuestoTestDataBuilder presupuestoTestDataBuilder = new PresupuestoTestDataBuilder(0.0, 10.0, "", 1);
        // act - assert
        BasePrueba.assertThrows(() -> presupuestoTestDataBuilder.build(), ExcepcionValorInvalido.class, "Proporcione un valor válido para el presupuesto");
    }

    @Test
    public void validarReservaNegativa() {
        // arrange
        PresupuestoTestDataBuilder presupuestoTestDataBuilder = new PresupuestoTestDataBuilder(10.0, -10.0, "", 1);
        // act - assert
        BasePrueba.assertThrows(() -> presupuestoTestDataBuilder.build(), ExcepcionValorInvalido.class, "Proporcione un valor válido para la reserva de estabilización");
    }

    @Test
    public void validarReservaCero() {
        // arrange
        PresupuestoTestDataBuilder presupuestoTestDataBuilder = new PresupuestoTestDataBuilder(10.0, 0.0, "", 1);
        // act - assert
        BasePrueba.assertThrows(() -> presupuestoTestDataBuilder.build(), ExcepcionValorInvalido.class, "Proporcione un valor válido para la reserva de estabilización");
    }

    @Test
    public void validarSinProyecto() {
        // arrange
        PresupuestoTestDataBuilder presupuestoTestDataBuilder = new PresupuestoTestDataBuilder(10.0, 1.0, "Observaciones", null);
        // act - assert
        BasePrueba.assertThrows(() -> presupuestoTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Indique el proyecto al que pertenece el presupuesto");
    }

    @Test
    public void validarSinValor() {
        // arrange
        PresupuestoTestDataBuilder presupuestoTestDataBuilder = new PresupuestoTestDataBuilder(null, 1.0, "Observaciones", 1);
        // act - assert
        BasePrueba.assertThrows(() -> presupuestoTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Proporcione un valor para el presupuesto");
    }

    @Test
    public void validarSinReserva() {
        // arrange
        PresupuestoTestDataBuilder presupuestoTestDataBuilder = new PresupuestoTestDataBuilder(10.0, null, "Observaciones", 1);
        // act - assert
        BasePrueba.assertThrows(() -> presupuestoTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Proporcione un valor para la reserva de estabilización");
    }
}
