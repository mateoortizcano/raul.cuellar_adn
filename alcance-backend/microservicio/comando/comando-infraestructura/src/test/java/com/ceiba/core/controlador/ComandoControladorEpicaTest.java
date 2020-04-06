package com.ceiba.core.controlador;

import com.ceiba.core.ApplicationMock;
import com.ceiba.core.comando.epica.ComandoEpica;
import com.ceiba.core.testdatabuilder.ComandoEpicaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=ApplicationMock.class)
@WebMvcTest(ComandoControladorEpica.class)
public class ComandoControladorEpicaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;
    
    

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoEpica epica = new ComandoEpicaTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/epicas")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(epica)))
        		.andExpect(status().isOk())
        		.andExpect(content().json("{'valor': 1}"));
    }
}
