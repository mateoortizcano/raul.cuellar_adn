package com.ceiba.core.servicio.sprint;

import com.ceiba.core.BasePrueba;
import com.ceiba.core.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.core.modelo.Sprint;
import com.ceiba.core.repositorio.RepositorioSprint;
import com.ceiba.core.servicio.testdatabuilder.SprintTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

public class ActualizarSprintTest {
	
	@Test
    public void validarSprintConNombreExistenteTest() {
        // arrange
		RepositorioSprint repositorioSprint = Mockito.mock(RepositorioSprint.class);
		Mockito.when(repositorioSprint.existeNombreExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(true);
		ServicioActualizarSprint servicioActualizarSprint = new ServicioActualizarSprint(repositorioSprint);
		Sprint sprint = new SprintTestDataBuilder(
				1L,
				"Sprint 0",
				LocalDateTime.now(),
				LocalDateTime.now(),
				3,
				1L
		).build();
        // act - assert
		BasePrueba.assertThrows(() -> servicioActualizarSprint.ejecutar(sprint),
				ExcepcionDuplicidad.class,
				"Ya existe un sprint con ese nombre");
    }
	@Test
	public void validarSprintConPeriodoExistenteTest() {
		// arrange
		RepositorioSprint repositorioSprint = Mockito.mock(RepositorioSprint.class);
		Mockito.when(repositorioSprint.existePeriodoExcluyendoId(
				Mockito.anyLong(),
				Mockito.any(),
				Mockito.any())).thenReturn(true);
		ServicioActualizarSprint servicioActualizarSprint = new ServicioActualizarSprint(repositorioSprint);
		Sprint sprint = new SprintTestDataBuilder(
				1L,
				"Sprint 0",
				LocalDateTime.now(),
				LocalDateTime.now(),
				3,
				1L
		).build();
		// act - assert
		BasePrueba.assertThrows(() -> servicioActualizarSprint.ejecutar(sprint),
				ExcepcionDuplicidad.class,
				"Ya existe un sprint para el periodo descrito");
	}
}
