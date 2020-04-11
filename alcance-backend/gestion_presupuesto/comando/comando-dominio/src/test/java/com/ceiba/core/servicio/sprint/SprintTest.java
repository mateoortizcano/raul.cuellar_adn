package com.ceiba.core.servicio.sprint;

import com.ceiba.core.BasePrueba;
import com.ceiba.core.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.core.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.core.modelo.Sprint;
import com.ceiba.core.servicio.testdatabuilder.SprintTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class SprintTest {

    @Test
    public void validarIdProyectoTest(){
        //Arrange
        SprintTestDataBuilder sprintTestDataBuilder = new SprintTestDataBuilder(
                1L,
                "Sprint 1",
                LocalDateTime.now(),
                LocalDateTime.now(),
                2,
                null);
        //Act - Assert
        BasePrueba.assertThrows(() -> sprintTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, "Indique el proyecto al que pertenece el sprint");
    }

    @Test
    public void validarFechaInicialTest(){
        //Arrange
        SprintTestDataBuilder sprintTestDataBuilder = new SprintTestDataBuilder(
                1L,
                "Sprint 1",
                null,
                LocalDateTime.now(),
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
                2,
                1L);
        //Act - Assert
        BasePrueba.assertThrows(() -> sprintTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, "Proporcione una fecha de finalización de sprint");
    }
    @Test
    public void validarFechasTest(){
        //Arrange
        SprintTestDataBuilder sprintTestDataBuilder = new SprintTestDataBuilder(
                1L,
                "Sprint 1",
                LocalDateTime.now(),
                LocalDateTime.now().minusDays(1L),
                2,
                1L);
        //Act - Assert
        BasePrueba.assertThrows(() -> sprintTestDataBuilder.build(),
                ExcepcionValorInvalido.class, "La fecha final debe ser posterior a la fecha final");
    }
    @Test
    public void validarDiasHabiles(){
        //Arrange
        SprintTestDataBuilder sprintTestDataBuilder = new SprintTestDataBuilder(
                1L,
                "Sprint 1",
                LocalDateTime.of(2020, 03, 17, 0,0,0),
                LocalDateTime.of(2020, 03, 24, 23,59,59),
                2,
                1L);
        //Act
        Sprint sprint = sprintTestDataBuilder.build();
        // Assert
        Assert.assertTrue(sprint.getDiasHabiles().equals(5));
    }
}
