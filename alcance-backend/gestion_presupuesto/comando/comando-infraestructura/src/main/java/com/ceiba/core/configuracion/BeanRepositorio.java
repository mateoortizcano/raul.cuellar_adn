package com.ceiba.core.configuracion;

import com.ceiba.core.repositorio.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;

@Configuration
public class BeanRepositorio {

	@Bean
	public RepositorioUsuario repositorioUsuario(CustomNamedParameterJdbcTemplate repositorioGenerico) {
		return new RepositorioUsuarioMysql(repositorioGenerico);
	}

	@Bean
	public RepositorioEpica repositorioEpica(CustomNamedParameterJdbcTemplate repositorioGenerico){
		return new RepositorioEpicaMysql(repositorioGenerico);
	}

	@Bean
	public RepositorioPresupuesto repositorioPresupuesto(CustomNamedParameterJdbcTemplate repositorioGenerico){
		return new RepositorioPresupuestoMysql(repositorioGenerico);
	}

	@Bean
	public RepositorioSprint repositorioSprint(CustomNamedParameterJdbcTemplate repositorioGenerico){
		return new RepositorioSprintMysql(repositorioGenerico);
	}
}