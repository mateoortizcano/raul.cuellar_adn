package com.ceiba.core.configuracion;

import com.ceiba.core.repositorio.RepositorioSprint;
import com.ceiba.core.servicio.sprint.ServicioActualizarSprint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.core.repositorio.RepositorioUsuario;
import com.ceiba.core.servicio.usuario.ServicioActualizarUsuario;
import com.ceiba.core.servicio.usuario.ServicioCrearUsuario;

@Configuration
public class BeanServicio {

	@Bean
	public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
		return new ServicioCrearUsuario(repositorioUsuario);
	}

	@Bean
	public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
		return new ServicioActualizarUsuario(repositorioUsuario);
	}

	@Bean
	public ServicioActualizarSprint servicioActualizarSprint(RepositorioSprint repositorioSprint){
		return new ServicioActualizarSprint(repositorioSprint);
	}
}
