package com.ceiba.core.repositorio;

import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.core.modelo.PresupuestoSprint;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public class RepositorioPresupuestoSprintMysql implements RepositorioPresupuestoSprint{

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="presupuesto", value="crear")
    private String sqlCrear;

    public RepositorioPresupuestoSprintMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(PresupuestoSprint presupuestoSprint) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", 1L);

        return this.customNamedParameterJdbcTemplate.crear(presupuestoSprint, this.sqlCrear);
    }
}
