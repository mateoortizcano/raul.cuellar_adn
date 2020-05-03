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
@WebMvcTest(ConsultaControladorProyecto.class)
public class ConsultaControladorProyectoTest {

	@Autowired
    private MockMvc mocMvc;

    @Test 
    public void listarProyectos() throws Exception {
        // arrange

        // act - assert
    	mocMvc.perform(get("/proyectos")
    		      .contentType(MediaType.APPLICATION_JSON))
    		      .andExpect(status().isOk())
    		      .andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].nombre", is("Proyecto1")))
				.andExpect(jsonPath("$[0].cliente", is("Cliente1")));
    }

	@Test
	public void listarProyectosResumen() throws Exception {
		// arrange

		// act - assert
		mocMvc.perform(get("/proyectos/resumen")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].nombre", is("Proyecto1")))
				.andExpect(jsonPath("$[0].cliente", is("Cliente1")))
				.andExpect(jsonPath("$[0].presupuestoGlobal", is(20.0)));
	}
}