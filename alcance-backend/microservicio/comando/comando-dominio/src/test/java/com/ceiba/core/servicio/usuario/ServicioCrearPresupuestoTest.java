package com.ceiba.core.servicio.usuario;

import com.ceiba.core.BasePrueba;
import com.ceiba.core.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.core.modelo.Presupuesto;
import com.ceiba.core.repositorio.RepositorioPresupuesto;
import com.ceiba.core.servicio.testdatabuilder.PresupuestoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearPresupuestoTest {

	@Test
	public void validarValorNegativo() {
		// arrange
		PresupuestoTestDataBuilder presupuestoTestDataBuilder = new PresupuestoTestDataBuilder(-1.0, 10.0, "");
		// act - assert
		BasePrueba.assertThrows(() -> presupuestoTestDataBuilder.build(), ExcepcionValorInvalido.class, "Proporcione un valor para el presupuesto");
	}

	@Test
	public void validarValorCero() {
		// arrange
		PresupuestoTestDataBuilder presupuestoTestDataBuilder = new PresupuestoTestDataBuilder(0.0, 10.0, "");
		// act - assert
		BasePrueba.assertThrows(() -> presupuestoTestDataBuilder.build(), ExcepcionValorInvalido.class, "Proporcione un valor para el presupuesto");
	}

	@Test
	public void validarReservaNegativa() {
		// arrange
		PresupuestoTestDataBuilder presupuestoTestDataBuilder = new PresupuestoTestDataBuilder(10.0, -10.0, "");
		// act - assert
		BasePrueba.assertThrows(() -> presupuestoTestDataBuilder.build(), ExcepcionValorInvalido.class, "Proporcione un valor para la reserva de estabilización");
	}

	@Test
	public void validarReservaCero() {
		// arrange
		PresupuestoTestDataBuilder presupuestoTestDataBuilder = new PresupuestoTestDataBuilder(10.0, 0.0, "");
		// act - assert
		BasePrueba.assertThrows(() -> presupuestoTestDataBuilder.build(), ExcepcionValorInvalido.class, "Proporcione un valor para la reserva de estabilización");
	}
}
