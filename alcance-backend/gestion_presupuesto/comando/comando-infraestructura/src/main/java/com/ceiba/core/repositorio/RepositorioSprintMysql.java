package com.ceiba.core.repositorio;

import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.core.modelo.Sprint;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class RepositorioSprintMysql implements RepositorioSprint {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@SqlStatement(namespace="sprint", value="actualizar")
	private String sqlActualizar;

	@SqlStatement(namespace="sprint", value="existeNombreExcluyendoId")
	private String sqlExisteNombreExcluyendoId;

	@SqlStatement(namespace="sprint", value="existeEnPeriodoExcluyendoId")
	private String sqlExisteEnPeriodoExcluyendoId;


	public RepositorioSprintMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public void actualizar(Sprint sprint) {
		this.customNamedParameterJdbcTemplate.actualizar(sprint, this.sqlActualizar);
	}

	@Override
	public boolean existeNombreExcluyendoId(Long id, String nombre) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);
		paramSource.addValue("nombre", nombre);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
				.queryForObject(sqlExisteNombreExcluyendoId,paramSource, Boolean.class);
	}

	@Override
	public boolean existePeriodoExcluyendoId(Long id, LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);
		paramSource.addValue("fechaInicial", fechaInicial);
		paramSource.addValue("fechaFinal", fechaFinal);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
				.queryForObject(sqlExisteEnPeriodoExcluyendoId,paramSource, Boolean.class);
	}
}
