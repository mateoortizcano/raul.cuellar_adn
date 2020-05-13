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

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=ApplicationMock.class)
@WebMvcTest(ConsultaControladorProyecto.class)
public class ConsultaControladorConceptoTest {
	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void listarConceptos() throws Exception {
		// arrange
		ConsultaCalendario consultaCalendario = new ConsultaCalendario(
				LocalDateTime.of(2020, 1, 5, 0,0,0),
				LocalDateTime.of(2020,1,5,0,0,0));
		// act - assert
		mocMvc.perform(post("/proyectos/1/conceptos")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(consultaCalendario)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(5)))
				.andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].nombre", is("Desarrollo")))
				.andExpect(jsonPath("$[0].gerencia", is("produccion")));
	}
}
