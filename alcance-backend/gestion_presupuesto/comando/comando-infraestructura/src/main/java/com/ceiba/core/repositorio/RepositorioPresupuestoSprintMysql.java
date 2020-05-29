package com.ceiba.core.repositorio;

import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.core.modelo.PresupuestoSprint;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.List;

public class RepositorioPresupuestoSprintMysql implements RepositorioPresupuestoSprint{

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="presupuestosprint", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "presupuestosprint", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "presupuestosprint", value = "eliminar")
    private static String sqlEliminar;

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
    public void eliminar(Long idSprint, List<Long> idPresupuestoSprint) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        String cadenaIds = "";
        if(!idPresupuestoSprint.isEmpty()){
            for (int index = 0; index < idPresupuestoSprint.size(); index++) {
                cadenaIds = cadenaIds.concat(String.valueOf(idPresupuestoSprint.get(index)).concat(","));
            }
            if (!cadenaIds.isEmpty()) {
                cadenaIds = cadenaIds.substring(0, cadenaIds.length() - 1);
            } else {
                cadenaIds = "-1";
            }
            cadenaIds = " AND id NOT IN (" . concat(cadenaIds) . concat(")");
        }
        paramSource.addValue("idSprint", idSprint);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar .concat(cadenaIds), paramSource);
    }
}
