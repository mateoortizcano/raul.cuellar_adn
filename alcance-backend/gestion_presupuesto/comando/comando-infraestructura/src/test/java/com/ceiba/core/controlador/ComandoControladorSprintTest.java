package com.ceiba.core.controlador;

import com.ceiba.core.ApplicationMock;
import com.ceiba.core.comando.ComandoSprint;
import com.ceiba.core.testdatabuilder.ComandoSprintTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=ApplicationMock.class)
@WebMvcTest(ComandoControladorSprint.class)
public class ComandoControladorSprintTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoSprint sprint = new ComandoSprintTestDataBuilder(
                1L,
                "Sprint 1",
                LocalDateTime.now(),
                LocalDateTime.now(),
                3,
                new ArrayList<Long>()
        ).build();

        // act - assert
        mocMvc.perform(post("/sprints")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(sprint)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 1}"));
    }

    @Test
    public void actualizar() throws Exception{
        // arrange
        Long id = 1L;
        ComandoSprint sprint = new ComandoSprintTestDataBuilder(
                id,
                "Otro nombre",
                LocalDateTime.now(),
                LocalDateTime.now(),
                10,
                new ArrayList<Long>()).build();

        // act - assert
        mocMvc.perform(put("/sprints/{id}",id)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(sprint)))
        		.andExpect(status().isOk());
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 1L;

        // act - assert
        mocMvc.perform(delete("/sprints/{id}",id)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
