package com.ceiba.core.servicio.sprint;

import com.ceiba.core.BasePrueba;
import com.ceiba.core.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.core.modelo.Sprint;
import com.ceiba.core.repositorio.RepositorioSprint;
import com.ceiba.core.servicio.testdatabuilder.SprintTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

public class CrearSprintTest {
	
	@Test
    public void validarCrearSprintConNombreExistenteTest() {
        // arrange
		RepositorioSprint repositorioSprint = Mockito.mock(RepositorioSprint.class);
		Mockito.when(repositorioSprint.existeNombre(Mockito.anyLong(), Mockito.anyString()))
				.thenReturn(true);
		ServicioCrearSprint servicioCrearSprint = new ServicioCrearSprint(repositorioSprint);
		Sprint sprint = new SprintTestDataBuilder(
				1L,
				"Sprint 0",
				LocalDateTime.now(),
				LocalDateTime.now(),
				3,
				1L
		).build();
        // act - assert
		BasePrueba.assertThrows(() -> servicioCrearSprint.ejecutar(sprint),
				ExcepcionDuplicidad.class,
				"Ya existe un sprint con ese nombre");
    }
	@Test
	public void validarCrearSprintConPeriodoExistenteTest() {
		// arrange
		RepositorioSprint repositorioSprint = Mockito.mock(RepositorioSprint.class);
		Mockito.when(repositorioSprint.existePeriodo(
				Mockito.anyLong(),
				Mockito.any(),
				Mockito.any())).thenReturn(true);
		ServicioCrearSprint servicioCrearSprint = new ServicioCrearSprint(repositorioSprint);
		Sprint sprint = new SprintTestDataBuilder(
				1L,
				"Sprint 0",
				LocalDateTime.now(),
				LocalDateTime.now(),
				3,
				1L
		).build();
		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearSprint.ejecutar(sprint),
				ExcepcionDuplicidad.class,
				"Ya existe un sprint para el periodo descrito");
	}
}
