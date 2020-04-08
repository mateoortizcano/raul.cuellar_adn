package com.ceiba.core.servicio.epica;

import com.ceiba.core.BasePrueba;
import com.ceiba.core.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.core.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.core.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.core.servicio.testdatabuilder.EpicaTestDataBuilder;
import org.junit.Test;

public class ServicioCrearEpicaTest {

	@Test
	public void validarSinTitulo() {
		// arrange
		EpicaTestDataBuilder epicaTestDataBuilder = new EpicaTestDataBuilder(null, 10);
		// act - assert
		BasePrueba.assertThrows(() -> epicaTestDataBuilder.build(), ExcepcionValorObligatorio.class, "La épica debe tener un título");
	}

	@Test
	public void validarConTituloVacio() {
		// arrange
		EpicaTestDataBuilder epicaTestDataBuilder = new EpicaTestDataBuilder("", 10);
		// act - assert
		BasePrueba.assertThrows(() -> epicaTestDataBuilder.build(), ExcepcionLongitudValor.class, "La épica debe tener un título");
	}
	@Test
	public void validarSinEstimacionComercial() {
		// arrange
		EpicaTestDataBuilder epicaTestDataBuilder = new EpicaTestDataBuilder("Título", null);
		// act - assert
		BasePrueba.assertThrows(() -> epicaTestDataBuilder.build(), ExcepcionValorObligatorio.class, "La épica debe tener una estimación comercial");
	}

	@Test
	public void validarEstimacionComercialCero() {
		// arrange
		EpicaTestDataBuilder epicaTestDataBuilder = new EpicaTestDataBuilder("Título", 0);
		// act - assert
		BasePrueba.assertThrows(() -> epicaTestDataBuilder.build(), ExcepcionValorInvalido.class, "La épica debe tener una estimación comercial");
	}

	@Test
	public void validarEstimacionComercialNegativa() {
		// arrange
		EpicaTestDataBuilder epicaTestDataBuilder = new EpicaTestDataBuilder("Título", -1);
		// act - assert
		BasePrueba.assertThrows(() -> epicaTestDataBuilder.build(), ExcepcionValorInvalido.class, "La épica debe tener una estimación comercial");
	}
}
