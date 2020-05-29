package com.ceiba.core.repositorio;

import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.core.modelo.Sprint;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.time.LocalDateTime;

public class RepositorioSprintMysql implements RepositorioSprint {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@SqlStatement(namespace = "sprint", value = "crear")
	private static String sqlCrear;

	@SqlStatement(namespace = "sprint", value = "actualizar")
	private static String sqlActualizar;

	@SqlStatement(namespace = "sprint", value = "existeNombre")
	private static String sqlExisteNombre;

	@SqlStatement(namespace = "sprint", value = "existeEnPeriodo")
	private static String sqlExisteEnPeriodo;

	@SqlStatement(namespace = "sprint", value = "existeNombreExcluyendoId")
	private static String sqlExisteNombreExcluyendoId;

	@SqlStatement(namespace = "sprint", value = "existeEnPeriodoExcluyendoId")
	private static String sqlExisteEnPeriodoExcluyendoId;

	@SqlStatement(namespace = "sprint", value = "eliminar")
	private static String sqlEliminar;

	public RepositorioSprintMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(Sprint sprint) {
		return this.customNamedParameterJdbcTemplate.crear(sprint, this.sqlCrear);
	}

	@Override
	public void actualizar(Sprint sprint) {
		this.customNamedParameterJdbcTemplate.actualizar(sprint, this.sqlActualizar);
	}

	private static final String PARAM_ID_PROYECTO = "idProyecto";

	@Override
	public boolean existeNombre(Long idProyecto, String nombre) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("nombre", nombre);
		paramSource.addValue(PARAM_ID_PROYECTO, idProyecto);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
				.queryForObject(sqlExisteNombre,paramSource, Boolean.class);
	}

	@Override
	public boolean existePeriodo(Long idProyecto, LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("fechaInicial", fechaInicial);
		paramSource.addValue("fechaFinal", fechaFinal);
		paramSource.addValue(PARAM_ID_PROYECTO, idProyecto);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
				.queryForObject(sqlExisteEnPeriodo,paramSource, Boolean.class);
	}

	@Override
	public boolean existeNombreExcluyendoId(Long id, String nombre, Long idProyecto) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);
		paramSource.addValue("nombre", nombre);
		paramSource.addValue(PARAM_ID_PROYECTO, idProyecto);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
				.queryForObject(sqlExisteNombreExcluyendoId,paramSource, Boolean.class);
	}

	@Override
	public boolean existePeriodoExcluyendoId(Long id, LocalDateTime fechaInicial, LocalDateTime fechaFinal, Long idProyecto) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);
		paramSource.addValue("fechaInicial", fechaInicial);
		paramSource.addValue("fechaFinal", fechaFinal);
		paramSource.addValue(PARAM_ID_PROYECTO, idProyecto);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
				.queryForObject(sqlExisteEnPeriodoExcluyendoId,paramSource, Boolean.class);
	}

	@Override
	public void eliminar(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);

		this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
	}
}
