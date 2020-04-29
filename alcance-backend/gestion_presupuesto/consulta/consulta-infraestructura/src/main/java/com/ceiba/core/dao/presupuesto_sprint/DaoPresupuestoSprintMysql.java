package com.ceiba.core.dao.presupuesto_sprint;

import com.ceiba.core.dao.DaoPresupuestoSprint;
import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.core.modelo.DtoPresupuestoSprint;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoPresupuestoSprintMysql implements DaoPresupuestoSprint {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="presupuesto_sprint", value="listar")
    private String sqlListar;

    public DaoPresupuestoSprintMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPresupuestoSprint> listar(Long idSprint) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idSprint", idSprint);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlListar, paramSource, new MapeoPresupuestoSprint());
    }
}
