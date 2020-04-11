package com.ceiba.core.controlador;

import com.ceiba.core.ApplicationMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=ApplicationMock.class)
@WebMvcTest(ConsultaControladorSprint.class)
public class ConsultaControladorSprintTest {

	@Autowired
    private MockMvc mocMvc;

    @Test 
    public void listar() throws Exception {
        // arrange

        // act - assert
    	mocMvc.perform(get("/sprint/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].nombre", is("Sprint 1")))
				.andExpect(jsonPath("$[0].fechaInicial", is("2020-03-17 00:00:00")))
				.andExpect(jsonPath("$[0].fechaFinal", is("2020-03-24 23:59:59")))
				.andExpect(jsonPath("$[0].diasHabiles", is(5)))
				.andExpect(jsonPath("$[0].numeroPersonas", is(3)))
				.andExpect(jsonPath("$[0].idProyecto", is(1)));
    }
}
