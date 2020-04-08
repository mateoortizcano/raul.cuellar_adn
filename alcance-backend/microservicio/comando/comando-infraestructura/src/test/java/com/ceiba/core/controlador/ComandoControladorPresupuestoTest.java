package com.ceiba.core.controlador;

import com.ceiba.core.ApplicationMock;
import com.ceiba.core.comando.ComandoPresupuesto;
import com.ceiba.core.testdatabuilder.ComandoPresupuestoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=ApplicationMock.class)
@WebMvcTest(ComandoControladorPresupuesto.class)
public class ComandoControladorPresupuestoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;
    
    @Test
    public void crear() throws Exception{
        // arrange
        ComandoPresupuesto presupuesto = new ComandoPresupuestoTestDataBuilder(
                988478952.0,
                98847895.0,
                UUID.randomUUID().toString()
        ).build();

        // act - assert
        mocMvc.perform(post("/presupuestos")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(presupuesto)))
        		.andExpect(status().isOk())
        		.andExpect(content().json("{'valor': 1}"));
    }
    @Test
    public void crearSinObservaciones() throws Exception{
        // arrange
        ComandoPresupuesto presupuesto = new ComandoPresupuestoTestDataBuilder(
                988478952.0,
                98847895.0
        ).build();

        // act - assert
        mocMvc.perform(post("/presupuestos")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(presupuesto)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 1L;

        // act - assert
        mocMvc.perform(delete("/presupuestos/{id}",id)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
