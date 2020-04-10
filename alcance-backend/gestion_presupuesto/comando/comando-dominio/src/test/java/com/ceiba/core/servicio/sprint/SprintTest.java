package com.ceiba.core.servicio.sprint;

import com.ceiba.core.BasePrueba;
import com.ceiba.core.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.core.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.core.modelo.Sprint;
import com.ceiba.core.servicio.testdatabuilder.SprintTestDataBuilder;
import org.junit.Test;

import java.time.LocalDateTime;

public class SprintTest {

    @Test
    public void validarFechaInicialTest(){
        //Arrange
        SprintTestDataBuilder sprintTestDataBuilder = new SprintTestDataBuilder(
                1L,
                "Sprint 1",
                null,
                LocalDateTime.now(),
                8,
                2,
                1L);
        //Act - Assert
        BasePrueba.assertThrows(() -> sprintTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, "Proporcione una fecha de inicio de sprint");
    }

    @Test
    public void validarFechaFinalTest(){
        //Arrange
        SprintTestDataBuilder sprintTestDataBuilder = new SprintTestDataBuilder(
                1L,
                "Sprint 1",
                LocalDateTime.now(),
                null,
                8,
                2,
                1L);
        //Act - Assert
        BasePrueba.assertThrows(() -> sprintTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, "Proporcione una fecha de finalizacion de sprint");
    }
    @Test
    public void validarFechasTest(){
        //Arrange
        SprintTestDataBuilder sprintTestDataBuilder = new SprintTestDataBuilder(
                1L,
                "Sprint 1",
                LocalDateTime.now(),
                LocalDateTime.now().minusDays(1L),
                8,
                2,
                1L);
        //Act - Assert
        BasePrueba.assertThrows(() -> sprintTestDataBuilder.build(),
                ExcepcionValorInvalido.class, "La fecha final debe ser posterior a la fecha final");
    }

}
