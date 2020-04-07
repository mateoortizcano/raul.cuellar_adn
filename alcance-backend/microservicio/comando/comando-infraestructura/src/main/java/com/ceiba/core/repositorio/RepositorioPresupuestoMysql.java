package com.ceiba.core.repositorio;

import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.core.modelo.Presupuesto;

public class RepositorioPresupuestoMysql implements RepositorioPresupuesto{

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="presupuesto", value="crear")
    private String sqlCrear;

    public RepositorioPresupuestoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Presupuesto presupuesto) {
        return this.customNamedParameterJdbcTemplate.crear(presupuesto, this.sqlCrear);
    }
}
