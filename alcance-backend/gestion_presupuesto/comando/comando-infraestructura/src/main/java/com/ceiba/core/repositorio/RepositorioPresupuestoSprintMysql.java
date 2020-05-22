package com.ceiba.core.repositorio;

import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.core.modelo.PresupuestoSprint;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.List;

public class RepositorioPresupuestoSprintMysql implements RepositorioPresupuestoSprint{

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="presupuestosprint", value="crear")
    private String sqlCrear;

    @SqlStatement(namespace = "presupuestosprint", value = "actualizar")
    private String sqlActualizar;

    @SqlStatement(namespace = "presupuestosprint", value = "eliminar")
    private String sqlEliminar;

    public RepositorioPresupuestoSprintMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(PresupuestoSprint presupuestoSprint) {
        return this.customNamedParameterJdbcTemplate.crear(presupuestoSprint, this.sqlCrear);
    }
    @Override
    public void actualizar(PresupuestoSprint presupuestoSprint) {
        this.customNamedParameterJdbcTemplate.actualizar(presupuestoSprint, this.sqlActualizar);
    }

    @Override
    public void eliminar(Long idSprint, List<Long> id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        String cadenaIds = "";
        for (int index = 0; index < id.size(); index++) {
            cadenaIds = cadenaIds.concat(String.valueOf(id.get(index)).concat(","));
        }
        if (!cadenaIds.isEmpty()) {
            cadenaIds = cadenaIds.substring(0, cadenaIds.length() - 1);
        } else {
            cadenaIds = "-1";
        }
        cadenaIds = " AND id NOT IN (" . concat(cadenaIds) . concat(")");
        paramSource.addValue("idsPermanecer", cadenaIds);
        paramSource.addValue("idSprint", idSprint);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar .concat(cadenaIds), paramSource);
    }
}
