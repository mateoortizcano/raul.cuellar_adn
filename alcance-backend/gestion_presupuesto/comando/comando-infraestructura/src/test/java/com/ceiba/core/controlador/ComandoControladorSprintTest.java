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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
    public void actualizar() throws Exception{
        // arrange
    	Long id = 1L;
        ComandoSprint sprint = new ComandoSprintTestDataBuilder(id, "Otro nombre", LocalDateTime.now(), LocalDateTime.now(), 10, 3).build();

        // act - assert
        mocMvc.perform(put("/sprint/{id}",id)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(sprint)))
        		.andExpect(status().isOk());
    }
}
