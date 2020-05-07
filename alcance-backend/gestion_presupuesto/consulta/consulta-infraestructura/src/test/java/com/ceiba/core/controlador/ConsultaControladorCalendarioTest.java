package com.ceiba.core.controlador;

import com.ceiba.core.ApplicationMock;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=ApplicationMock.class)
@WebMvcTest(ConsultaControladorCalendario.class)
public class ConsultaControladorCalendarioTest {

    @Autowired
    private ObjectMapper objectMapper;

	@Autowired
    private MockMvc mocMvc;

    @Test 
    public void consultarDiasHabiles() throws Exception {
        // arrange
        ConsultaCalendario consultaCalendario = new ConsultaCalendario(
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        // act - assert
    	mocMvc.perform(post("/calendario")
    		        .contentType(MediaType.TEXT_PLAIN)
                    .content(objectMapper.writeValueAsString(consultaCalendario)))
    		      .andExpect(status().isOk());
    }
    

}
