package com.ceiba.core.configuracion;

import com.ceiba.core.servicio.presupuesto.ServicioEliminarPresupuesto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.core.repositorio.RepositorioEpica;
import com.ceiba.core.servicio.epica.ServicioCrearEpica;

import com.ceiba.core.repositorio.RepositorioUsuario;
import com.ceiba.core.servicio.usuario.ServicioActualizarUsuario;
import com.ceiba.core.servicio.usuario.ServicioCrearUsuario;
import com.ceiba.core.servicio.usuario.ServicioEliminarUsuario;

import com.ceiba.core.repositorio.RepositorioPresupuesto;
import com.ceiba.core.servicio.presupuesto.ServicioCrearPresupuesto;

@Configuration
public class BeanServicio {

	@Bean
	public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
		return new ServicioCrearUsuario(repositorioUsuario);
	}

	@Bean
	public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
		return new ServicioEliminarUsuario(repositorioUsuario);
	}
	
	@Bean
	public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
		return new ServicioActualizarUsuario(repositorioUsuario);
	}

	@Bean
	public ServicioCrearEpica servicioCrearEpica(RepositorioEpica repositorioEpica){
		return new ServicioCrearEpica(repositorioEpica);
	}

	@Bean
	public ServicioCrearPresupuesto servicioCrearPresupuesto(RepositorioPresupuesto repositorioPresupuesto){
		return new ServicioCrearPresupuesto(repositorioPresupuesto);
	}

	@Bean
	public ServicioEliminarPresupuesto servicioEliminarPresupuesto(RepositorioPresupuesto repositorioPresupuesto){
		return new ServicioEliminarPresupuesto(repositorioPresupuesto);
	}
}
