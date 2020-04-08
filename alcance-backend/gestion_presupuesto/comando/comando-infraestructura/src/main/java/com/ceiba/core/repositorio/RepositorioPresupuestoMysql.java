package com.ceiba.core.repositorio;

import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.core.modelo.Presupuesto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public class RepositorioPresupuestoMysql implements RepositorioPresupuesto{

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="presupuesto", value="crear")
    private String sqlCrear;

    @SqlStatement(namespace="presupuesto", value="eliminar")
    private String sqlEliminar;

    public RepositorioPresupuestoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Presupuesto presupuesto) {
        return this.customNamedParameterJdbcTemplate.crear(presupuesto, this.sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }
}
