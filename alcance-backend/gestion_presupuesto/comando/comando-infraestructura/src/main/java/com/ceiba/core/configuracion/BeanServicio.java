package com.ceiba.core.configuracion;

import com.ceiba.core.repositorio.RepositorioSprint;
import com.ceiba.core.servicio.sprint.ServicioActualizarSprint;
import com.ceiba.core.servicio.sprint.ServicioCrearSprint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

	@Bean
	public ServicioCrearSprint servicioCrearSprint(RepositorioSprint repositorioSprint){
		return new ServicioCrearSprint(repositorioSprint);
	}

	@Bean
	public ServicioActualizarSprint servicioActualizarSprint(RepositorioSprint repositorioSprint){
		return new ServicioActualizarSprint(repositorioSprint);
	}
}
