package com.ceiba.core.configuracion;

import com.ceiba.core.repositorio.RepositorioEpica;
import com.ceiba.core.repositorio.RepositorioEpicaMysql;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.repositorio.RepositorioUsuario;
import com.ceiba.core.repositorio.RepositorioUsuarioMysql;

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

}
