package com.ceiba.core.dao.presupuesto;

import com.ceiba.core.dao.DaoPresupuesto;
import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.core.modelo.DtoPresupuesto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoPresupuestoMysql implements DaoPresupuesto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="presupuesto", value="listar")
    private String sqlListar;

    public DaoPresupuestoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPresupuesto> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPresupuesto());
    }
}
