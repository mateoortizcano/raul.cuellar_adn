package com.ceiba.core.repositorio;

import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.core.modelo.Sprint;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioSprintMysql implements RepositorioSprint {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@SqlStatement(namespace="sprint", value="actualizar")
	private String sqlActualizar;


	public RepositorioSprintMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public void actualizar(Sprint sprint) {
		this.customNamedParameterJdbcTemplate.actualizar(sprint, this.sqlActualizar);
	}
}
