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
@WebMvcTest(ConsultaControladorPresupuesto.class)
public class ConsultaControladorPresupuestoTest {

	@Autowired
    private MockMvc mocMvc;

    @Test 
    public void listar() throws Exception {
        // arrange

        // act - assert
    	mocMvc.perform(get("/presupuestos")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].valor", is(10.0)))
				.andExpect(jsonPath("$[0].reservaEstabilizacion", is(1.0)))
				.andExpect(jsonPath("$[0].idProyecto", is(1)));
    }

	@Test
	public void listarGlobal() throws Exception {
		// arrange
		Long idProyecto = 1L;
		// act - assert
		mocMvc.perform(get("/presupuestos/global/{idProyecto}", idProyecto)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].valor", is(22.0)))
				.andExpect(jsonPath("$[0].reservaEstabilizacion", is(2.0)))
				.andExpect(jsonPath("$[0].idProyecto", is(1)));
	}

}
